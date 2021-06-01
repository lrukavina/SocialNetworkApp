package hr.rukavina.socialnetworkapp.Comment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CommentService implements CommentServiceInterface {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDTO> findByPostId(String postId) {
        return commentRepository.findByPostId(postId).stream().map(this::mapCommentToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CommentDTO> saveNewComment(CommentCommand commentCommand) {
        Comment comment = mapCommentToEntity(commentCommand);

        return commentRepository.saveNewComment(comment).map(this::mapCommentToDTO);
    }


    public CommentDTO mapCommentToDTO(final Comment comment){
        return new CommentDTO(comment.getId(), comment.getAuthor(), comment.getContent(), comment.getPostId());
    }

    public Comment mapCommentToEntity(final CommentCommand commentCommand){
        Comment comment = new Comment();
        comment.setId(commentCommand.getId());
        if(commentCommand.getAuthor().equals("anonymous")){
            Random rand = new Random();
            Integer authorNum = rand.nextInt();
            if(authorNum < 0) authorNum *= -1;
            comment.setAuthor("anonymous"+authorNum.toString());
        }
        else {
            comment.setAuthor(commentCommand.getAuthor());
        }
        comment.setContent(commentCommand.getContent());
        comment.setPostId(commentCommand.getPostId());
        return comment;
    }
}

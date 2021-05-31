package hr.rukavina.socialnetworkapp.Comment;

import org.springframework.stereotype.Service;

import java.util.List;
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

    public CommentDTO mapCommentToDTO(final Comment comment){
        return new CommentDTO(comment.getId(), comment.getAuthor(), comment.getContent());
    }
}

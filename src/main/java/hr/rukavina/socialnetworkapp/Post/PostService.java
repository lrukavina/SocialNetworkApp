package hr.rukavina.socialnetworkapp.Post;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PostService implements PostServiceInterface{

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<PostDTO> findAll() {
        return postRepository.findAll().stream().map(this::mapPostToDTO).collect(Collectors.toList());
    }

    @Override
    public PostDTO findById(final String id) {
        return postRepository.findById(id).map(this::mapPostToDTO).orElse(null);
    }

    @Override
    public Optional<PostDTO> reactOnPost(String id, PostCommand postCommand) {
        Post post = mapPostToEntity(postCommand);

        return postRepository.reactOnPost(post).map(this::mapPostToDTO);
    }

    @Override
    public Optional<PostDTO> saveNewPost(PostCommand postCommand) {
        Post post = mapPostToEntity(postCommand);

        return postRepository.saveNewPost(post).map(this::mapPostToDTO);
    }


    public PostDTO mapPostToDTO(final Post post){
        return new PostDTO(post.getId(), post.getTitle(), post.getImageUrl(), post.getText(),
                post.getRating(), post.getAuthor());
    }

    public Post mapPostToEntity(final PostCommand postCommand){
        Post post = new Post();
        post.setId(postCommand.getId());
        post.setTitle(postCommand.getTitle());
        post.setImageUrl(postCommand.getImageUrl());
        post.setText(postCommand.getText());
        post.setRating(postCommand.getRating());
        if(postCommand.getAuthor().equals("anonymous")){
            Random rand = new Random();
            Integer authorNum = rand.nextInt();
            post.setAuthor("anonymous"+authorNum.toString());
        }
        else {
            post.setAuthor(postCommand.getAuthor());
        }

        return post;
    }


}

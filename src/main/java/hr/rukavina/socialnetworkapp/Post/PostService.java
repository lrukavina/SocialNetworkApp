package hr.rukavina.socialnetworkapp.Post;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Optional<PostDTO> upvotePost(String id, PostCommand postCommand) {
        Post post = mapPostToEntitiy(postCommand);

        return postRepository.upvotePost(post).map(this::mapPostToDTO);
    }

    public PostDTO mapPostToDTO(final Post post){
        return new PostDTO(post.getId(), post.getTitle(), post.getImageUrl(), post.getText(), post.getRating());
    }

    public Post mapPostToEntitiy(final PostCommand postCommand){
        Post post = new Post();
        post.setId(postCommand.getId());
        post.setTitle(postCommand.getTitle());
        post.setImageUrl(postCommand.getImageUrl());
        post.setText(postCommand.getText());
        post.setRating(postCommand.getRating());

        return post;
    }


}

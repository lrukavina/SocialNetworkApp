package hr.rukavina.socialnetworkapp.Post;

import org.springframework.stereotype.Service;

import java.util.List;
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

    public PostDTO mapPostToDTO(final Post post){
        return new PostDTO(post.getId(), post.getTitle(), post.getText());
    }
}

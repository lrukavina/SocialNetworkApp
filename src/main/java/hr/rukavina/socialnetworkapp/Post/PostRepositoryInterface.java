package hr.rukavina.socialnetworkapp.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepositoryInterface {
    List<Post> findAll();
    Optional<Post> findById(String id);
    Optional<Post> upvotePost(Post post);
}

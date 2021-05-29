package hr.rukavina.socialnetworkapp.Post;

import java.util.List;
import java.util.Optional;

public interface PostServiceInterface {
    List<PostDTO> findAll();
    PostDTO findById(final String id);
    Optional<PostDTO> upvotePost(final String id, PostCommand postCommand);
}

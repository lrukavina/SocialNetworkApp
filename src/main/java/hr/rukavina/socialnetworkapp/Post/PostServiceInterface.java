package hr.rukavina.socialnetworkapp.Post;

import java.util.List;
import java.util.Optional;

public interface PostServiceInterface {
    List<PostDTO> findAll();
    PostDTO findById(final String id);
    Optional<PostDTO> reactOnPost(final String id, PostCommand postCommand);
    Optional<PostDTO> saveNewPost(final  PostCommand postCommand);
}

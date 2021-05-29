package hr.rukavina.socialnetworkapp.Post;

import java.util.List;

public interface PostServiceInterface {
    List<PostDTO> findAll();
    PostDTO findById(final String id);
}

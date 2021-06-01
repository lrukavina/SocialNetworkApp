package hr.rukavina.socialnetworkapp.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentServiceInterface {
    List<CommentDTO> findByPostId(String postId);
    Optional<CommentDTO> saveNewComment(final CommentCommand commentCommand);
}

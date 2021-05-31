package hr.rukavina.socialnetworkapp.Comment;

import java.util.List;

public interface CommentServiceInterface {
    List<CommentDTO> findByPostId(String postId);
}

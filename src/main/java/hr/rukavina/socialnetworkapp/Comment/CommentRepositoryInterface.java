package hr.rukavina.socialnetworkapp.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepositoryInterface {
   List<Comment>findByPostId(String postId);
}

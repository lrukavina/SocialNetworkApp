package hr.rukavina.socialnetworkapp.Comment;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public List<CommentDTO> getCommentByPostId(@PathVariable final String id){
        return commentService.findByPostId(id);
    }
}

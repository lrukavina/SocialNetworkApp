package hr.rukavina.socialnetworkapp.Comment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<CommentDTO> save(@Valid @RequestBody final CommentCommand command){
        return commentService.saveNewComment(command)
                .map(
                        vaccineDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(vaccineDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }
}

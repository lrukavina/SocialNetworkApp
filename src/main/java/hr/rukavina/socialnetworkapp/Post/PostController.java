package hr.rukavina.socialnetworkapp.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable final String id){
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> react(@PathVariable final String id,
                                          @Valid @RequestBody final PostCommand postCommand){
        return postService.reactOnPost(id, postCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () ->ResponseEntity.notFound().build()
                );
    }

    @PostMapping
    public ResponseEntity<PostDTO> save(@Valid @RequestBody final PostCommand command){
        return postService.saveNewPost(command)
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

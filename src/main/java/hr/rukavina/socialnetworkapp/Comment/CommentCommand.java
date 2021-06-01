package hr.rukavina.socialnetworkapp.Comment;

import javax.validation.constraints.NotNull;

public class CommentCommand {

    private Long id;

    @NotNull(message = "Author must be entered")
    private String author;

    @NotNull(message = "Content must be entered")
    private String content;

    @NotNull(message = "Post id must be entered")
    private Long postId;

    public CommentCommand(Long id,
                          @NotNull(message = "Author must be entered") String author,
                          @NotNull(message = "Content must be entered") String content,
                          @NotNull(message = "Post id must be entered") Long postId) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}

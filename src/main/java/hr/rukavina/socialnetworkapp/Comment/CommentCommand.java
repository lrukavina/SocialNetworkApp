package hr.rukavina.socialnetworkapp.Comment;

import javax.validation.constraints.NotNull;

public class CommentCommand {

    private Long id;

    @NotNull(message = "Author must be entered")
    private String author;

    @NotNull(message = "Content must be entered")
    private String content;

    public CommentCommand(Long id,
                          @NotNull(message = "Author must be entered") String author,
                          @NotNull(message = "Content must be entered") String content) {
        this.id = id;
        this.author = author;
        this.content = content;
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
}

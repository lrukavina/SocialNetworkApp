package hr.rukavina.socialnetworkapp.Comment;

public class CommentDTO {
    private Long id;
    private String author;
    private String content;
    private Long postId;

    public CommentDTO(Long id, String author, String content, Long postId) {
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

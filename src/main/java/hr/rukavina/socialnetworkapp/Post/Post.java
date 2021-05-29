package hr.rukavina.socialnetworkapp.Post;

public class Post {
    private Long id;
    private String title;
    private String imageUrl;
    private String text;

    public Post(Long id, String title, String imageUrl, String text) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
    }

    public Post() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

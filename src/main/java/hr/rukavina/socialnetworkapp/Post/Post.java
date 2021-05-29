package hr.rukavina.socialnetworkapp.Post;

public class Post {
    private Long id;
    private String title;
    private String imageUrl;
    private String text;
    private Integer rating;

    public Post(Long id, String title, String imageUrl, String text, Integer rating) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
        this.rating = rating;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

package hr.rukavina.socialnetworkapp.Post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PostCommand {

    private Long id;

    @NotBlank(message = "Title must not be empty")
    private String title;

    @NotNull(message = "Image url must be entered")
    private String imageUrl;

    @NotBlank(message = "Text must not be empty")
    private String text;

    @NotNull(message = "Rating must be entered")
    private Integer rating;

    @NotNull(message = "Author must be entered")
    private String author;

    public PostCommand(Long id,
                       @NotBlank(message = "Title must not be empty") String title,
                       @NotNull(message = "Image url must be entered") String imageUrl,
                       @NotBlank(message = "Text must not be empty") String text,
                       @NotNull(message = "Rating must be entered") Integer rating,
                       @NotNull(message = "Author must be entered") String author) {

        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
        this.rating = rating;
        this.author = author;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

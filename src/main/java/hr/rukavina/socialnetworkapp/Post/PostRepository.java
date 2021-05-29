package hr.rukavina.socialnetworkapp.Post;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class PostRepository implements PostRepositoryInterface{

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert postInserter;

    public PostRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
        this.postInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("post")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public List<Post> findAll() {
        return jdbc.query("SELECT * FROM POST", this::mapRowToPost);
    }

    @Override
    public Optional<Post> findById(String id) {
        List<Post> posts = jdbc.query("SELECT * FROM POST WHERE id = ?", this::mapRowToPost, id);
        return Optional.of(posts.get(0));
    }

    public Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException{
        Post post = new Post();
        post.setId(rs.getLong("id"));
        post.setTitle(rs.getString("title"));
        post.setText(rs.getString("post_text"));
        return post;
    }
}

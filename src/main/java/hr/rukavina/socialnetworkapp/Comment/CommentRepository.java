package hr.rukavina.socialnetworkapp.Comment;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepository implements CommentRepositoryInterface {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert commentInserter;

    public CommentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.commentInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("comment")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public List<Comment> findByPostId(String postId) {
        return jdbc.query("SELECT * FROM COMMENT WHERE POST_ID = ?",this::mapRowToComment, postId);
    }


    public Comment mapRowToComment(ResultSet rs, int rowNum) throws SQLException{
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setAuthor(rs.getString("author"));
        comment.setContent(rs.getString("content"));
        return comment;
    }
}


package com.kiet.library.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kiet.library.model.Book;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbc;

    public BookRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<Book> bookMapper = new RowMapper<Book>() {
        @Override
        public Book mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Book b = new Book();
            b.setBookId(rs.getInt("book_id"));
            b.setTitle(rs.getString("title"));
            b.setAuthor(rs.getString("author"));
            b.setCategory(rs.getString("category"));
            b.setPublicationYear(
                    rs.getInt("publication_year"));
            b.setAvailable(rs.getBoolean("available"));
            return b;
        }
    };

    public List<Book> findAll() {
        return jdbc.query(
                "SELECT * FROM books ORDER BY book_id",
                bookMapper);
    }

    public List<Book> findById(int id) {
        return jdbc.query(
                "SELECT * FROM books WHERE book_id = ?",
                bookMapper, id);
    }

    public int insert(Book b) {
        String sql = "INSERT INTO books " +
                "(book_id, title, author, category, " +
                "publication_year, available) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        return jdbc.update(sql,
                b.getBookId(),
                b.getTitle(),
                b.getAuthor(),
                b.getCategory(),
                b.getPublicationYear(),
                b.isAvailable());
    }

    public int update(Book b, int id) {
        String sql = "UPDATE books SET title=?, author=?, " +
                "category=?, publication_year=?, available=? " +
                "WHERE book_id=?";

        return jdbc.update(sql,
                b.getTitle(),
                b.getAuthor(),
                b.getCategory(),
                b.getPublicationYear(),
                b.isAvailable(),
                id);
    }

    public int deleteById(int id) {
        return jdbc.update(
                "DELETE FROM books WHERE book_id = ?", id);
    }

    public List<Book> findByCategory(String category) {
        return jdbc.query(
                "SELECT * FROM books WHERE LOWER(category)=LOWER(?)",
                bookMapper, category);
    }

    public List<Book> findPublishedFromYear(int year) {
        return jdbc.query(
                "SELECT * FROM books WHERE publication_year >= ?",
                bookMapper, year);
    }
}

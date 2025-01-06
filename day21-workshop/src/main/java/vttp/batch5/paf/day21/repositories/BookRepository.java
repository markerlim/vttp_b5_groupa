package vttp.batch5.paf.day21.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day21.models.Book;

import static vttp.batch5.paf.day21.repositories.Queries.*;
import static vttp.batch5.paf.day21.repositories.Utils.*;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate template;

    public Optional<Book> getBookByAsin(String asin) {

        SqlRowSet rs = template.queryForRowSet(SQL_GET_BOOK_BY_ID, asin);
        if (!rs.next())
            return Optional.empty();

        Book b =  toBook(rs);
        return Optional.of(b);
    }

    public List<Book> getBooksByAuthor(String author, int count) {

        // %author%
        SqlRowSet rs = template.queryForRowSet(SQL_GET_BOOKS_BY_AUTHOR, "%%%s%%".formatted(author), count);
        List<Book> books = new LinkedList<>();
        while (rs.next())
            books.add(toBookSummary(rs));

        return books;
    }
}

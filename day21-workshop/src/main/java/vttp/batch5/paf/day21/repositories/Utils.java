package vttp.batch5.paf.day21.repositories;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import vttp.batch5.paf.day21.models.Book;

public class Utils {

    public static Book toBookSummary(SqlRowSet rs) {
        Book b = new Book();
        b.setAsin(rs.getString("asin"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        return b;
    }

}

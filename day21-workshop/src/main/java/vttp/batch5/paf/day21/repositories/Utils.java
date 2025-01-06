package vttp.batch5.paf.day21.repositories;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import vttp.batch5.paf.day21.models.Book;

public class Utils {

    public static Book toBook(SqlRowSet rs) {
        Book b = new Book();
        b.setAsin(rs.getString("asin"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setSoldBy(rs.getString("soldBy"));
        b.setImgUrl(rs.getString("imgUrl"));
        b.setProductUrl(rs.getString("productURL"));
        b.setStars(rs.getFloat("stars"));
        b.setReviews(rs.getInt("reviews"));
        b.setPrice(rs.getFloat("price"));
        b.setPublishedDate(rs.getDate("publishedDate"));
        b.setCategoryName(rs.getString("category_name"));
        return b;

    }

    public static Book toBookSummary(SqlRowSet rs) {
        Book b = new Book();
        b.setAsin(rs.getString("asin"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        return b;
    }

}

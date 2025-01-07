package vttp.batch5.paf.day22.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class KindleRepository {

    @Autowired
    private JdbcTemplate template;

    public void getAuthorAverageRating(int bookCount, int limit) {

        SqlRowSet rs = template.queryForRowSet(
            Queries.SQL_AUTHOR_SUMMARY, bookCount, limit);

       while (rs.next()) {
            String author = rs.getString("author");
            int count = rs.getInt("bk_count");
            float bookAvg = rs.getFloat("bk_avg");

            System.out.printf("Author: %s\nCount: %d\nAverage%f\n\n", author, count, bookAvg);
       }
    }

}

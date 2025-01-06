package vttp.batch5.paf.day21.repositories;

public class Queries {

    public static final String SQL_GET_BOOKS_BY_AUTHOR = """
        select asin, title, author from kindle
            where author like ?
            order by title asc
            limit ?
    """;

    public static final String SQL_GET_BOOK_BY_ID = """
        select * from kindle where asin = ?
    """;
}

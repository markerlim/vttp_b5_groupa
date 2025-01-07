package vttp.batch5.paf.day22.repositories;

public class Queries {
    public static final String SQL_AUTHOR_SUMMARY = """
        select author, count(title) bk_count, avg(stars) bk_avg
           	from kindle
           	where author != ""
           	group by author
           	having bk_count > ?
           	order by bk_count desc
           	limit ?;
    """;
}

package vttp.batch5.paf.day21.repositories;

public class Queries {

    public static final String SQL_SELECT_GAME_LIMIT =
        """
        select * from game limit ?
        """;

    public static final String SQL_SELECT_GAME =
        """
            select * from game limit 10
        """;
}

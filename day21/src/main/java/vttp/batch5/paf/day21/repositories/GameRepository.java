package vttp.batch5.paf.day21.repositories;

import static vttp.batch5.paf.day21.repositories.Queries.*;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import vttp.batch5.paf.day21.models.Game;

@Repository
public class GameRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Game> getGames(int limit) {
        /// select * from game where limit ?
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME_LIMIT, limit);
        List<Game> results = new LinkedList<>();

        // will return true if there are records to read
        while (rs.next()) {
            results.add(Game.toMovie(rs));
        }

        return results;
    }

    public List<Game> getGames() {
        return getGames(5);
    }
}

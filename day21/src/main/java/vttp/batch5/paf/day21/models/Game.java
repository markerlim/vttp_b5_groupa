package vttp.batch5.paf.day21.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {

    private int gameId;
    private String name;
    private int year;
    private int ranking;
    private int usersRated;
    private String url;
    private String image;

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return this.gameId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return this.ranking;
    }

    public void setUsersRated(int usersRated) {
        this.usersRated = usersRated;
    }

    public int getUsersRated() {
        return this.usersRated;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public static Game toMovie(SqlRowSet rs) {
        Game m = new Game();
        m.setYear(rs.getInt("year"));
        m.setUrl(rs.getString("url"));
        m.setName(rs.getString("name"));
        m.setGameId(rs.getInt("gid"));
        m.setImage(rs.getString("image"));
        m.setRanking(rs.getInt("ranking"));
        m.setUsersRated(rs.getInt("users_rated"));
        return m;
    }
}

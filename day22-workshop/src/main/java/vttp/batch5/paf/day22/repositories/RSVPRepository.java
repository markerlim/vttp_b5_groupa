package vttp.batch5.paf.day22.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day22.models.RSVP;

@Repository
public class RSVPRepository {

    @Autowired
    private JdbcTemplate template;

    public List<RSVP> getRSVPs() {

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_ALL_RSPVS);
        List<RSVP> rsvps = new LinkedList<>();
        while (rs.next()) {
            RSVP r = new RSVP();
            r.setRSVPId(rs.getString("rsvp_id"));
            r.setEmail(rs.getString("email"));
            r.setPhone(rs.getString("phone"));
            r.setComments(rs.getString("comments"));
            r.setConfirmDate(rs.getDate("confirm_date"));
            rsvps.add(r);
        }
        return rsvps;
    }

}

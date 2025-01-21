package vttp.batch5.paf.day26.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day26.models.ArtistSong;

import static vttp.batch5.paf.day26.repositories.Constants.*;

@Repository
public class SpotifyRepository {

  @Autowired
  private MongoTemplate template;

  // db.spotify_songs.distinct('released_year')
  public List<Integer> getYears() {
    Criteria criteria = Criteria
        .where(F_RELEASED_YEAR).gte(1980)
        .andOperator(
            Criteria.where(F_RELEASED_YEAR).lte(1989));

    Query query = Query.query(criteria);

    //return template.findDistinct(query,
    return template.findDistinct(new Query(),
        F_RELEASED_YEAR, C_SPOTIFY_SONGS, Integer.class);
  }

  //
  // db.spotify_songs
  //    .find({ released_year: year })
  //    .projection({ _id: 0, track_name: 1, 'artist(s)_name': 1 })
  //    .sort({ track_name: 1, 'artist(s)_name': 1 })
  public List<ArtistSong> findTrackByYear(int year) {

    Criteria criteria = Criteria.where(F_RELEASED_YEAR).is(year);

    Query query = Query.query(criteria)
        .with(Sort.by(Sort.Direction.ASC, 
              F_TRACK_NAME, F_ARTISTS_NAME));
    query.fields()
        .include(F_TRACK_NAME, F_ARTISTS_NAME)
        .exclude("_id");

    return template.find(query, Document.class, C_SPOTIFY_SONGS)
        .stream()
        .map(doc -> {
          ArtistSong as = new ArtistSong();
          try {
            as.setTrackName(doc.getString(F_TRACK_NAME));
          } catch (Exception ex) {
            as.setTrackName(doc.get(F_TRACK_NAME).toString());
          }
          as.setArtistName(doc.getString(F_ARTISTS_NAME));
          return as;
        })
        .toList();
      
  }
}

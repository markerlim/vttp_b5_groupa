package vttp.batch5.paf.day26.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.day26.repositories.SpotifyRepository;
import vttp.batch5.paf.day26.models.ArtistSong;

@Service
public class SpotifyService {

  @Autowired
  private SpotifyRepository spotifyRepo;

  public List<Integer> getYears() {
    return spotifyRepo.getYears();
  }

  public List<ArtistSong> findTrackByYear(int year) {
    return spotifyRepo.findTrackByYear(year);
  }
}

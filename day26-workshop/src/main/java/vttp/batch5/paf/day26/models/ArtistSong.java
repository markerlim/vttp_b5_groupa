package vttp.batch5.paf.day26.models;

public class ArtistSong {

  private String trackName;
  private String artistNames;

  public void setTrackName(String trackName) { this.trackName = trackName; }
  public String getTrackName() { return this.trackName; }

  public void setArtistName(String artistNames) { this.artistNames = artistNames; }
  public String getArtistName() { return this.artistNames; }

  @Override
  public String toString() {
    return "ArtistSong{trackName=%s, artistNames=%s}"
        .formatted(trackName, artistNames);
  }
}

package vttp.batch5.paf.day26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vttp.batch5.paf.day26.models.ArtistSong;
import vttp.batch5.paf.day26.services.SpotifyService;

@Controller
@RequestMapping
public class SpotifyController {

  @Autowired
  private SpotifyService spotifySvc;

  @GetMapping(path="/spotify/search")
  public ModelAndView search( @RequestParam int year) {
    List<ArtistSong> tracks = spotifySvc.findTrackByYear(year);

    System.out.printf(">>>> %s\n", tracks);

    ModelAndView mav = new ModelAndView("artist_tracks");
    mav.addObject("year", year);
    mav.addObject("tracks", tracks);
    mav.setStatus(HttpStatusCode.valueOf(200));

    return mav;
  }

  @GetMapping(path={"/index.html", "/"})
  public ModelAndView getIndex() {

    List<Integer> years = spotifySvc.getYears();

    ModelAndView mav = new ModelAndView("index");
    mav.addObject("years", years);
    mav.setStatus(HttpStatusCode.valueOf(200));

    return mav;
  }
}

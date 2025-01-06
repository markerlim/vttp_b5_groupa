package vttp.batch5.paf.day21.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vttp.batch5.paf.day21.models.Game;
import vttp.batch5.paf.day21.services.GameService;

@Controller
@RequestMapping
public class GameController {

    @Autowired
    private GameService gameSvc;

    @GetMapping("/games")
    public ModelAndView getGames(@RequestParam(defaultValue = "5") int count) {
        List<Game> games = gameSvc.getGames(count);
        ModelAndView mav = new ModelAndView("games");
        mav.addObject("games", games);
        mav.setStatus(HttpStatusCode.valueOf(200));
        return mav;
    }
}

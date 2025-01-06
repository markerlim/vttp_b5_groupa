package vttp.batch5.paf.day21.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vttp.batch5.paf.day21.models.Game;
import vttp.batch5.paf.day21.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    public List<Game> getGames() {
        return gameRepo.getGames(5);
    }

    public List<Game> getGames(int count) {
        return gameRepo.getGames(count);
    }
}

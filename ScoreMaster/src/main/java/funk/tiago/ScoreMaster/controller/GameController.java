package funk.tiago.ScoreMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import funk.tiago.ScoreMaster.model.Card;
import funk.tiago.ScoreMaster.model.CardRequest;
import funk.tiago.ScoreMaster.model.Game;
import funk.tiago.ScoreMaster.model.GameRequest;
import funk.tiago.ScoreMaster.model.Goal;
import funk.tiago.ScoreMaster.model.GoalRequest;
import funk.tiago.ScoreMaster.model.Player;
import funk.tiago.ScoreMaster.repository.CardRepository;
import funk.tiago.ScoreMaster.repository.ClubRepository;
import funk.tiago.ScoreMaster.repository.GameRepository;
import funk.tiago.ScoreMaster.repository.GoalRepository;
import funk.tiago.ScoreMaster.repository.PlayerRepository;
import funk.tiago.ScoreMaster.repository.StadiumRepository;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private StadiumRepository stadiumRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private CardRepository cardRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Game>> getAllGames(){
        return ResponseEntity.ok(gameRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Game> createGame(@RequestBody GameRequest req) {

        Game game = new Game();
        game.setDate(req.getDate());
        game.setCapacity(req.getCapacity());

        game.setStadium(stadiumRepository.findById(req.getStadiumId())
            .orElseThrow(() -> new RuntimeException("Estádio não encontrado")));

        game.setHomeClub(clubRepository.findById(req.getHomeClubId())
            .orElseThrow(() -> new RuntimeException("Clube mandante não encontrado")));

        game.setAwayClub(clubRepository.findById(req.getAwayClubId())
            .orElseThrow(() -> new RuntimeException("Clube visitante não encontrado")));

        gameRepository.save(game);

        if (req.getGoals() != null) {
            for (GoalRequest g : req.getGoals()) {
                Goal goal = new Goal();
                goal.setMinute(g.getMinute());
                goal.setOwnGoal(g.isOwnGoal());
                goal.setPenaltyGoal(g.isPenaltyGoal());

                Player p = playerRepository.findById(g.getPlayerId())
                    .orElseThrow(() -> new RuntimeException("Player do gol não encontrado"));

                goal.setPlayer(p);
                goalRepository.save(goal);

                game.getGoals().add(goal);
            }
        }

        if (req.getCards() != null) {
            for (CardRequest c : req.getCards()) {
                Card card = new Card();
                card.setMinute(c.getMinute());
                card.setYellowCard(c.isYellowCard());

                Player p = playerRepository.findById(c.getPlayerId())
                    .orElseThrow(() -> new RuntimeException("Player do cartão não encontrado"));

                card.setPlayer(p);
                cardRepository.save(card);

                game.getCards().add(card);
            }
        }

        Game saved = gameRepository.save(game);

        return ResponseEntity.ok(saved);
    }
}

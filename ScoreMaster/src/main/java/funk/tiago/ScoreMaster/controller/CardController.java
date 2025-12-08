package funk.tiago.ScoreMaster.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import funk.tiago.ScoreMaster.model.Card;
import funk.tiago.ScoreMaster.model.CardRequest;
import funk.tiago.ScoreMaster.model.Player;
import funk.tiago.ScoreMaster.repository.CardRepository;
import funk.tiago.ScoreMaster.repository.PlayerRepository;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardRepository cardRepository;
    private final PlayerRepository playerRepository;

    public CardController(CardRepository cardRepository, PlayerRepository playerRepository) {
        this.cardRepository = cardRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Card>> getAllCards(){
        return ResponseEntity.ok(cardRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Card> saveGoal(@RequestBody CardRequest req ){
         Player player = playerRepository.findById(req.getPlayerId())
        .orElseThrow(() -> new RuntimeException("Player not found!"));

        Card card = new Card();
        card.setPlayer(player);
        card.setMinute(req.getMinute());
        card.setYellowCard(req.isYellowCard());

        Card created = cardRepository.save(card);

        return ResponseEntity.ok(created);
    }
}

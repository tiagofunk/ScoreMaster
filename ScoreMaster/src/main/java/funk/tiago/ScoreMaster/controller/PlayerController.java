package funk.tiago.ScoreMaster.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import funk.tiago.ScoreMaster.model.Player;
import funk.tiago.ScoreMaster.repository.PlayerRepository;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Player>> getAllPlayers(){
        return ResponseEntity.ok(playerRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable long id){
        return playerRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Player savePlayer(@RequestBody Player player ){
        return playerRepository.save(player);
    }
}

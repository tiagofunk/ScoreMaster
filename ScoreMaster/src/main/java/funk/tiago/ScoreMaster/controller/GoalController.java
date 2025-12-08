package funk.tiago.ScoreMaster.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import funk.tiago.ScoreMaster.model.Goal;
import funk.tiago.ScoreMaster.model.GoalRequest;
import funk.tiago.ScoreMaster.model.Player;
import funk.tiago.ScoreMaster.repository.GoalRepository;
import funk.tiago.ScoreMaster.repository.PlayerRepository;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private final GoalRepository goalRepository;
    private final PlayerRepository playerRepository;

    public GoalController(GoalRepository goalRepository, PlayerRepository playerRepository) {
        this.goalRepository = goalRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Goal>> getAllGoals(){
        return ResponseEntity.ok(goalRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Goal> saveGoal(@RequestBody GoalRequest req ){
         Player player = playerRepository.findById(req.getPlayerId())
        .orElseThrow(() -> new RuntimeException("Player not found!"));

        Goal goal = new Goal();
        goal.setPlayer(player);
        goal.setMinute(req.getMinute());
        goal.setOwnGoal(req.isOwnGoal());
        goal.setPenaltyGoal(req.isPenaltyGoal());

        Goal created = goalRepository.save(goal);

        return ResponseEntity.ok(created);
    }
}

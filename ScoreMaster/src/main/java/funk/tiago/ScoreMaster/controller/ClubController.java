package funk.tiago.ScoreMaster.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import funk.tiago.ScoreMaster.model.Club;
import funk.tiago.ScoreMaster.repository.ClubRepository;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubRepository clubRepository;

    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Club>> getAllClubs(){
        return ResponseEntity.ok(clubRepository.findAll());
    }

    @PostMapping("/")
    public Club saveClub(@RequestBody Club club ){
        return clubRepository.save(club);
    }
}

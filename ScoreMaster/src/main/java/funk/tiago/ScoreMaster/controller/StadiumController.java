package funk.tiago.ScoreMaster.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import funk.tiago.ScoreMaster.model.Stadium;
import funk.tiago.ScoreMaster.repository.StadiumRepository;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final StadiumRepository stadiumRepository;

    public StadiumController(StadiumRepository clubRepository) {
        this.stadiumRepository = clubRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Stadium>> getAllStadiums(){
        return ResponseEntity.ok(stadiumRepository.findAll());
    }

    @PostMapping("/")
    public Stadium saveClub(@RequestBody Stadium stadium ){
        return stadiumRepository.save(stadium);
    }
}

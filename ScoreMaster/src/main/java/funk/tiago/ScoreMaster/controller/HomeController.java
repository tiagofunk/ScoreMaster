package funk.tiago.ScoreMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import funk.tiago.ScoreMaster.repository.StadiumRepository;

@Controller
public class HomeController {

    private final StadiumRepository stadiumRepository;

    public HomeController(StadiumRepository repository) {
        this.stadiumRepository = repository;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/createplayer")
    public String createPlayerPage() {
        return "createplayer";
    }

    @GetMapping("/creategame")
    public String createGamePage() {
        return "creategame";
    }

    @GetMapping("/createclub")
    public String createClubPage() {
        return "createclub";
    }

    @GetMapping("/createstadium")
    public String createStadiumPage() {
        return "createstadium";
    }

    @GetMapping("/estadios")
    public String stadiumsPage(Model model) {
        model.addAttribute("stadiums", stadiumRepository.findAll());
        return "stadiums";
    }
}

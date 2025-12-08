package funk.tiago.ScoreMaster.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_stadium")
    private Stadium stadium;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "id_home_club")
    private Club homeClub;
    @ManyToOne
    @JoinColumn(name = "id_away_club")
    private Club awayClub;

    @OneToMany
    @JoinColumn(name = "id_game")
    private List<Goal> goals = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "id_card")
    private List<Card> cards = new ArrayList<>();

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Club getHomeClub() {
        return homeClub;
    }
    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }
    public Club getAwayClub() {
        return awayClub;
    }
    public void setAwayClub(Club awayClub) {
        this.awayClub = awayClub;
    }
    public Stadium getStadium() {
        return stadium;
    }
    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public List<Goal> getGoals() {
        return goals;
    }
    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }
    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    
    
}

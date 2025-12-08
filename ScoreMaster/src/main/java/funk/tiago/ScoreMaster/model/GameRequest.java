package funk.tiago.ScoreMaster.model;

import java.util.Date;
import java.util.List;

public class GameRequest {

    private Date date;
    private int capacity;

    private Long stadiumId;
    private Long homeClubId;
    private Long awayClubId;

    private List<GoalRequest> goals;
    private List<CardRequest> cards;

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public Long getStadiumId() {
        return stadiumId;
    }
    public void setStadiumId(Long stadiumId) {
        this.stadiumId = stadiumId;
    }
    public Long getHomeClubId() {
        return homeClubId;
    }
    public void setHomeClubId(Long homeClubId) {
        this.homeClubId = homeClubId;
    }
    public Long getAwayClubId() {
        return awayClubId;
    }
    public void setAwayClubId(Long awayClubId) {
        this.awayClubId = awayClubId;
    }
    public List<GoalRequest> getGoals() {
        return goals;
    }
    public void setGoals(List<GoalRequest> goals) {
        this.goals = goals;
    }
    public List<CardRequest> getCards() {
        return cards;
    }
    public void setCards(List<CardRequest> cards) {
        this.cards = cards;
    }
    
    
}

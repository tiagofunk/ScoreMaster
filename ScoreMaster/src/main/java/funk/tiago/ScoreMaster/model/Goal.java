package funk.tiago.ScoreMaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;
    private String minute;
    private boolean homeGoal;
    private boolean ownGoal;
    private boolean penaltyGoal;
    public boolean isHomeGoal() {
        return homeGoal;
    }
    public void setHomeGoal(boolean homeGoal) {
        this.homeGoal = homeGoal;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public String getMinute() {
        return minute;
    }
    public void setMinute(String minute) {
        this.minute = minute;
    }
    public boolean isOwnGoal() {
        return ownGoal;
    }
    public void setOwnGoal(boolean ownGoal) {
        this.ownGoal = ownGoal;
    }
    public boolean isPenaltyGoal() {
        return penaltyGoal;
    }
    public void setPenaltyGoal(boolean penaltyGoal) {
        this.penaltyGoal = penaltyGoal;
    }
    
}

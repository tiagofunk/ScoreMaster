package funk.tiago.ScoreMaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;
    private boolean yellowCard;
    private String minute;
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
    public boolean isYellowCard() {
        return yellowCard;
    }
    public void setYellowCard(boolean yellowCard) {
        this.yellowCard = yellowCard;
    }
    public String getMinute() {
        return minute;
    }
    public void setMinute(String minute) {
        this.minute = minute;
    }
    
}

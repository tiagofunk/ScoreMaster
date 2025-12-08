package funk.tiago.ScoreMaster.model;

public class CardRequest {
    private Long playerId;
    private boolean homeCard;
    private boolean yellowCard;
    private String minute;
    public Long getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
        public boolean isHomeCard() {
        return homeCard;
    }
    public void setHomeCard(boolean homeCard) {
        this.homeCard = homeCard;
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

package funk.tiago.ScoreMaster.model;

public class GoalRequest {
    private Long playerId;
    private String minute;
    private boolean homeGoal;
    private boolean ownGoal;
    private boolean penaltyGoal;
    public Long getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
        public boolean isHomeGoal() {
        return homeGoal;
    }
    public void setHomeGoal(boolean homeGoal) {
        this.homeGoal = homeGoal;
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

package BattleShip.model;

public class PlayerChanceATarget {

    final Player targetPlayer;
    final Coordinate coordinate;

    public PlayerChanceATarget(Player targetPlayer, Coordinate coordinate) {
        this.targetPlayer = targetPlayer;
        this.coordinate = coordinate;
    }

    public Player getTargetPlayer(){
        return this.targetPlayer;
    }
    public Coordinate getTarget(){
        return this.coordinate;
    }
}

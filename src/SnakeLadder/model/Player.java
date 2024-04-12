package SnakeLadder.model;

public class Player {

    private final  int playerId;
    private final  String playerName;

    public Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public int getPlayerId(){
        return playerId;
    }
}

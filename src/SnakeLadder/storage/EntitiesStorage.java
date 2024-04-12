package SnakeLadder.storage;

import SnakeLadder.model.Player;

import java.util.List;

public interface EntitiesStorage {
    void setSnake(int start,int end);

    void setLadder(int start,int end);

    void setPlayers( String playerName );

    List<Player> getAllPlayers();
    String getPlayerName(int playerId);

    int isCaughtBySnake(int endPos);

    int ladderFound(int endPos);
}

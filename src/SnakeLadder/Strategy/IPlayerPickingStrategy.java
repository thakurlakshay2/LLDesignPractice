package SnakeLadder.Strategy;



import SnakeLadder.model.Player;

import java.util.List;

public interface IPlayerPickingStrategy {

    int firstPlayer(List<Player> allPlayers);
    int pickNextPlayer(int currentPlayerId,List<Player> allPlayers);
}

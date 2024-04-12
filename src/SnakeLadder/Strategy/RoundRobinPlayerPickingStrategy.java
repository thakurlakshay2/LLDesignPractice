package SnakeLadder.Strategy;

import SnakeLadder.Exceptions.NoPlayersInTheGameException;
import SnakeLadder.model.Player;

import java.util.List;

public class RoundRobinPlayerPickingStrategy implements  IPlayerPickingStrategy {

    @Override
    public int firstPlayer(List<Player> allPlayers) {
        if(allPlayers.isEmpty()){
            throw new NoPlayersInTheGameException();
        }

        return allPlayers.get(0).getPlayerId();
    }

    @Override
    public int pickNextPlayer(int currentPlayerId, List<Player> allPlayers) {
        System.out.println(currentPlayerId);
        return (currentPlayerId+1)%allPlayers.size();
    }
}

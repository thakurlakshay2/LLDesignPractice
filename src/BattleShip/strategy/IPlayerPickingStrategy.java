package BattleShip.strategy;

import BattleShip.model.Player;

import java.util.List;

public interface IPlayerPickingStrategy {
    Integer firstPlayer(List<Player> allPlayers);
    Integer pickNextPlayer(Integer currentPlayerIndex,List<Player> allPlayers);

}

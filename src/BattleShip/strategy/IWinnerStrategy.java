package BattleShip.strategy;

import BattleShip.model.Player;

import java.util.List;

public interface IWinnerStrategy {
    public Player getWinner(List<Player> playerList );
}

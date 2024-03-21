package BattleShip.strategy;

import BattleShip.model.Player;

import java.util.List;

public interface IChanceGeneratorStrategy {

    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}

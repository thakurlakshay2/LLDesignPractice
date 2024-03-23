package BattleShip.strategy;

import BattleShip.model.Player;
import BattleShip.model.PlayerChanceATarget;

import java.util.List;

public interface IChanceGeneratorStrategy {

    PlayerChanceATarget getPlayerChanceTarget(List<Player> opponents);
}

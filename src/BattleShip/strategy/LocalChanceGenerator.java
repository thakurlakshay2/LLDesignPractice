package BattleShip.strategy;

import BattleShip.model.Player;
import BattleShip.model.PlayerChanceATarget;

import java.util.List;

public class LocalChanceGenerator implements IChanceGeneratorStrategy {

    @Override
    public PlayerChanceATarget getPlayerChanceTarget(List<Player> opponents) {
       final PlayerInput playerInput=inputProvider.takeInput();
       Player targetPlayer=null;

       for(Player player:opponents){
           if(player.getId()==playerInput.getNum())
           {
               targetPlayer=player;
           }
       }

       if(targetPlayer==null){
           throw new InvalidInputException();
       }
       return new PlayerChanceATarget(targetPlayer,new Coordinate(playerInput.getTargetX(),playerInput.getTargetY()));
    }


}

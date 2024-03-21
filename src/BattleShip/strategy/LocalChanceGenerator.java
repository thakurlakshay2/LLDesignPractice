package BattleShip.strategy;

public class LocalChanceGenerator implements IChanceGeneratorStrategy {

    @Override
    public PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents) {
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
       return new PlayerChanceTarget(targetPlayer,new Coordinate(playerInput.getTargetX(),playerInput.getTargetY()))
    }
}

package BattleShip.model;

import BattleShip.strategy.IChanceGeneratorStrategy;

import java.util.ArrayList;

public class Player {

    private final Board board;
    private final int id;

    private final IChanceGeneratorStrategy chanceGeneratorStragergy;

   public PlayerChanceTarget takeChance(List<Player> allPlayers){
       List<Player> opponents= new ArrayList<>();

       for(Player player:allPlayers){
           if(player.getId!=getId()){
               opponents.add(player);
           }
       }

       return chanceGeneratorStragergy.getPlayerChanceTarget(opponents);
   }

   public boolean areAllShipKilled(){
       return board.areAllShipsKilled();
   }

   public void takeHit(final Coordinate coordinate){
       board.takeHit(coordinate);
   }
}

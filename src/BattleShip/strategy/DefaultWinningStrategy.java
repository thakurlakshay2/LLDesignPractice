package BattleShip.strategy;

import BattleShip.model.Player;

import java.util.ArrayList;
import java.util.List;

public class DefaultWinningStrategy implements  IWinnerStrategy {
    @Override
    public Player getWinner(final List<Player> playerList){
        final List<Player> alivePLayers= new ArrayList<>();
        for(Player player: playerList){
            if(!player.areAllShipKilled()){
                alivePLayers.add(player);
            }
        }
        if(alivePLayers.size()==1){
            return alivePLayers.get(0);
        }
        return null;
    }


}

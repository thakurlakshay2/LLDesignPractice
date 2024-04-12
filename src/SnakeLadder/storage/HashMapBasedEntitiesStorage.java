package SnakeLadder.storage;

import SnakeLadder.Exceptions.LadderAlreadyPlacedException;
import SnakeLadder.Exceptions.SnakeAlreadyPlacedException;
import SnakeLadder.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapBasedEntitiesStorage implements EntitiesStorage {
    private HashMap<Integer,Integer> snakes;
    private HashMap<Integer,Integer> ladders;

    private HashMap<Integer,String> players;

    private List<Player> allPlayers;

    public HashMapBasedEntitiesStorage() {
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.players = new HashMap<>();
        this.allPlayers=new ArrayList<>();
    }

    @Override
    public void setLadder(int startPos, int endPos) {
        if(ladders.containsKey(endPos)){
            throw new LadderAlreadyPlacedException(endPos);
        }
        ladders.put(startPos,endPos);
    }

    @Override
    public void setSnake(int startPos, int endPos){
        if(snakes.containsKey(startPos)){
            throw new SnakeAlreadyPlacedException(startPos);
        }
        snakes.put(startPos,endPos);
    }


    public void setPlayers(String playerName) {
        Player player=new Player(players.size(), playerName);

        players.put(players.size(), playerName);
        allPlayers.add(player);
    }

    public List<Player> getAllPlayers(){
        return allPlayers;
    }

    public String getPlayerName(int playerId){
        return players.get(playerId);
    }

    public int isCaughtBySnake(int endPos){
        if(snakes.containsKey(endPos)){
            return snakes.get(endPos);
        }

            return endPos;
    }

    public int ladderFound(int endPos){
        if(ladders.containsKey(endPos)){
            return ladders.get(endPos);
        }
        return endPos;
    }

}

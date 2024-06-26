package SnakeLadder.service;

import SnakeLadder.Strategy.IPlayerPickingStrategy;
import SnakeLadder.model.Board;
import SnakeLadder.model.Dice;
import SnakeLadder.model.Player;
import SnakeLadder.storage.EntitiesStorage;
import SnakeLadder.storage.IBoardStorage;

import java.util.List;

public class GameService {


    private final Dice dice;
    private final EntitiesStorage storage;

    private final Board boardObj;
    private final IBoardStorage board;
    private final IPlayerPickingStrategy playerPickingStrategy;


    public GameService(int diceNumber, EntitiesStorage storage, IBoardStorage board, IPlayerPickingStrategy playerPickingStrategy, Board boardObj) {
        this.dice=new Dice(diceNumber);
        this.playerPickingStrategy=playerPickingStrategy;
        this.storage=storage;
        this.board=board;
        this.boardObj=boardObj;
    }

    public void startGame(){

        initilizePlayersStartValue();
        int playerId= playerPickingStrategy.firstPlayer(storage.getAllPlayers());
          while (true){
            StringBuilder sb=new StringBuilder();

            sb.append(storage.getPlayerName(playerId));
              int diceRoll= dice.rollDice();

              int currentPosition= board.getPlayerPosition(playerId);
              int endPosition=currentPosition+diceRoll;

                String s1="";
              if(checkforNumberLessThanOrEqualThanBoardSize(endPosition)) {
                  //
                  sb.append(" rolled a " + diceRoll);
                  sb.append(" and moved from " + currentPosition + " position to " + endPosition + " position");

                  if (storage.isCaughtBySnake(endPosition) != endPosition) {
                      s1 = " after bit by snake ";
                      board.setPlayerPosition(playerId, storage.isCaughtBySnake(endPosition));
                  } else {
                      if (storage.ladderFound(endPosition) != endPosition) {
                          s1 = " after ladder ride ";
                      }
                      board.setPlayerPosition(playerId, storage.ladderFound(endPosition));
                  }

                  sb.append(" to ").append(board.getPlayerPosition(playerId));
                  sb.append(s1);


              }
              if(board.getPlayerPosition(playerId)==boardObj.getBoardSize() ){
                  System.out.println(storage.getPlayerName(playerId)+" WON!!!");
                  break;
              }
              playerId=playerPickingStrategy.pickNextPlayer(playerId,storage.getAllPlayers());
              System.out.println(sb.toString());

          }

    }

    private boolean checkforNumberLessThanOrEqualThanBoardSize(int endPos){
       return endPos<=boardObj.getBoardSize();
    }
    private void initilizePlayersStartValue(){
        List<Player> allPlayers=storage.getAllPlayers();
        for(int i=0;i<allPlayers.size();i++){
            board.setPlayerPosition(allPlayers.get(i).getPlayerId(),0);
        }
    }

}

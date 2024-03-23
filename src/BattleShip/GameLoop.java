package BattleShip;

import BattleShip.model.Player;
import BattleShip.model.PlayerChanceATarget;
import BattleShip.strategy.IPlayerPickingStrategy;

import java.util.List;

public class GameLoop {
    private  final List<Player> players;
    private final IWinnerStrategy winnerStrategy;

    private final IOutputPrinter printer;

    private final IPlayerPickingStrategy nextPlayerStrategy;

    public GameLoop(List<Player> players, IWinnerStrategy winnerStrategy, IOutputPrinter printer, IPlayerOickingStrategy nextPlayerStrategy) {
        this.players = players;
        this.winnerStrategy = winnerStrategy;
        this.printer = printer;
        this.nextPlayerStrategy = nextPlayerStrategy;
    }

    public void start(){
        int currentPlayerIndex=nextPlayerStrategy.firstPlayer(this.players);
        printMsg("Starting Game");
        while (true){
            final Player currentPlayer = players.get(currentPlayerIndex);
            printer.printMsg("\n\nPlayer:"+currentPlayer.getId() + " chance");

            final PlayerChanceATarget playerChanceATarget= currentPlayer.takeChance(this.players);
            try{
                playerChanceATarget.getTargetPlayer().takeHit(playerChanceATarget.getTarget());
            }catch(CoordinateOutOfBoundException exception){
                printer.printMsg("Hit Was out of bound");
            }

            printer.printSelfBoard(currentPlayer);
            printer.printOpponentBoard(players,currentPlayer);

            final Player winner= winnerStrategy.getWinner(players);
            if(winner!=null){
                printer.printMsg(winner);
                break;
            }
            currentPlayerIndex=nextPlayerStrategy.pickNextPlayer(currentPlayerIndex,this.players);
        }
    }
}

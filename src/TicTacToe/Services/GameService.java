package TicTacToe.Services;

import TicTacToe.Model.Board;
import TicTacToe.Model.PieceType;
import TicTacToe.Model.Player;
import TicTacToe.Model.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameService {
    Deque<Player> players;
    Board board;

    public GameService() {

        this.players = new LinkedList<>();
        PlayingPieceX crossPiece=new PlayingPieceX();
        Player p1=new Player("p1", crossPiece);

        PlayingPieceX noughtsPiece=new PlayingPieceX();
        Player p2=new Player("p2", crossPiece);

        players.add(p1);
        players.add(p2);
        this.board = new Board(3);
    }

    public String startGame(){
        boolean noWinner=true;
        while (noWinner){
            Player playerTurn=players.removeFirst();
            board.printBoard();
            List<Integer> freeSpaces=board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }
            System.out.println("Player: "+playerTurn.getPlayerName()+ " Entr row,column:");
            Scanner scn=new Scanner(System.in);
            String s=scn.nextLine();
            String[] values=s.split(",");
            int inputRow=Integer.valueOf(values[0]);
            int inputCol=Integer.valueOf(values[1]);

            boolean pieceAddedSuccessFully= board.addPiece(inputRow,inputCol,playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessFully){
                System.out.println("Incorrect position choesn try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner= iSThereWinner(inputRow,inputCol,playerTurn.getPlayingPiece().pieceType);
            if(winner){
                return playerTurn.getPlayerName();
            }

        }
        return "tie";
    }

    private boolean iSThereWinner(int row, int col, PieceType pieceType){
       return board.rowCheck(pieceType,row)|| board.colCheck(pieceType,col) || board.diagnolCheck(pieceType,row,col);
    }
}

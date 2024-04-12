package TicTacToe.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size;

    private final PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public int getSize(){
        return size;
    }
    public boolean addPiece(int row , int column, PlayingPiece playingPiece){
        if(board[row][column]!=null){
            return false;
        }
        board[row][column]=playingPiece;
        return true;
    }
    public List<Integer> getFreeCells(){
        List<Integer> freeCells=new ArrayList<>();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    int  rowColumn=i*size+j;
                    freeCells.add(rowColumn);
                }
            }
        }
        return freeCells;
    }

    public void printBoard(){
        for(PlayingPiece[] boardRow:board){
            for(PlayingPiece b:boardRow){
                System.out.print(b.pieceType + " | ");
            }
            System.out.println("---------------");
        }
    }

    public boolean rowCheck(PieceType pieceType,int row){
        boolean valid=true;
        for(int c1=0;c1<size;c1++){
            valid= valid && board[row][c1].pieceType==pieceType;
        }
        return valid;
    }
    public boolean colCheck(PieceType pieceType,int col){
        boolean valid=true;
        for(int c1=0;c1<size;c1++){
            valid= valid && board[c1][col].pieceType==pieceType;
        }
        return valid;
    }

    public boolean diagnolCheck(PieceType pieceType,int row,int col){
        if(row!=col){
            return false;
        }

        boolean valid=true;
        for(int c1=0;c1<size;c1++){
            valid= valid && board[c1][c1].pieceType==pieceType;
        }
        return valid;
    }
}

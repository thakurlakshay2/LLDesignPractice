package TicTacToe;

import TicTacToe.Services.GameService;

public class Main {
    public static void main(String[] args) {
        GameService game=new GameService();
        System.out.println(game.startGame());
    }
}

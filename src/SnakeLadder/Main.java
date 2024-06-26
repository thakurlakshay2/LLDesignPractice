package SnakeLadder;

import SnakeLadder.Strategy.IPlayerPickingStrategy;
import SnakeLadder.Strategy.RoundRobinPlayerPickingStrategy;
import SnakeLadder.model.Board;
import SnakeLadder.service.*;
import SnakeLadder.storage.BoardStorage;
import SnakeLadder.storage.EntitiesStorage;
import SnakeLadder.storage.HashMapBasedEntitiesStorage;
import SnakeLadder.storage.IBoardStorage;

public class Main {

    public static void main(String[] args) {
        Board newBoard=new Board(100);
        EntitiesStorage hashMapBasedEntitiesStorage=new HashMapBasedEntitiesStorage(newBoard);
        IBoardStorage board=new BoardStorage();
        IPlayerPickingStrategy playerPickingStrategy=new RoundRobinPlayerPickingStrategy();

        InputService snakeInput=new SnakeInputService(hashMapBasedEntitiesStorage);
        snakeInput.getInput();

        InputService ladderInput=new LadderInputService(hashMapBasedEntitiesStorage);
        ladderInput.getInput();

        InputService playerInput=new PlayerInputService(hashMapBasedEntitiesStorage);
        playerInput.getInput();


        GameService gameService=new GameService(6,hashMapBasedEntitiesStorage,board ,playerPickingStrategy,newBoard);
        gameService.startGame();


    }
}

package SnakeLadder.storage;

import java.util.HashMap;

public class BoardStorage implements IBoardStorage{

    private final HashMap<Integer,Integer> board;

    public BoardStorage() {
        this.board = new HashMap<>();
    }

    @Override
    public int getPlayerPosition(int playerId) {
        return board.get(playerId);
    }

    @Override
    public void setPlayerPosition(int playerId, int position) {
        board.put(playerId,position);
    }
}

package SnakeLadder.storage;

public interface IBoardStorage {

    public int getPlayerPosition(int playerId);

    public void setPlayerPosition(int playerId,int position);
}

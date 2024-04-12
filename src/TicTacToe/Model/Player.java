package TicTacToe.Model;

public class Player {
    private final String playerName;
    private  PlayingPiece playingPiece;

    public Player(String playerName, PlayingPiece playingPiece) {
        this.playerName = playerName;
        this.playingPiece = playingPiece;
    }

    public String getPlayerName(){
        return playerName;
    }

    public PlayingPiece getPlayingPiece(){
        return playingPiece;
    }
    public void setPlayingPiece(){
        this.playingPiece=playingPiece;
    }
}

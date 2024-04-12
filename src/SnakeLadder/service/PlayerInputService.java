package SnakeLadder.service;

import SnakeLadder.storage.EntitiesStorage;

import java.util.Scanner;

public class PlayerInputService implements InputService{
    private final EntitiesStorage storage;

    public PlayerInputService(EntitiesStorage storage) {
        this.storage = storage;
    }

    @Override
    public void getInput() {
        Scanner scn=new Scanner(System.in);
        System.out.println("Please enter number of players");
        int noOfPlayers= scn.nextInt();

        for(int i=0;i<noOfPlayers;i++){
            System.out.println("plz enter player name");
            String playerName=scn.next();
            storage.setPlayers(playerName);
        }
    }
}

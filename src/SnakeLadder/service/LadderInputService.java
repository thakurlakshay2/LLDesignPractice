package SnakeLadder.service;

import SnakeLadder.storage.EntitiesStorage;

import java.util.Scanner;

public class LadderInputService implements InputService {
    private final EntitiesStorage storage;

    public LadderInputService(EntitiesStorage storage) {
        this.storage = storage;
    }

    @Override
    public void getInput() {
        Scanner scn=new Scanner(System.in);
        System.out.println("Please enter number of ladders");
        int noOfLadders= scn.nextInt();
        for(int i=0;i<noOfLadders;i++){
            System.out.println("Please start and end point of ladder");
            int startPos=scn.nextInt();
            int endPos=scn.nextInt();
            storage.setLadder(startPos,endPos);
        }

    }
}



package SnakeLadder.service;

import SnakeLadder.storage.EntitiesStorage;

import java.util.Scanner;

public class SnakeInputService implements InputService {

    private final EntitiesStorage storage;

    public SnakeInputService(EntitiesStorage entities) {
        this.storage = entities;
    }

    public void getInput(){
        Scanner scn=new Scanner(System.in);
        System.out.println("Please enter number of snakes");
        int noOfSnakes= scn.nextInt();
        while (noOfSnakes>0){
            System.out.println("Please enter their  positions");
            int startPosition= scn.nextInt();
            int endPosition = scn.nextInt();

            storage.setSnake(startPosition,endPosition);
            noOfSnakes--;
        }
    }
}

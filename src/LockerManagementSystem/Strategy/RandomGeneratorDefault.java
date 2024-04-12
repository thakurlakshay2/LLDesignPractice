package LockerManagementSystem.Strategy;

public class RandomGeneratorDefault implements IRandomGenerator {

    @Override
    public int getRandomNumber(int size) {
        return (int) (Math.random() * size );
    }
}

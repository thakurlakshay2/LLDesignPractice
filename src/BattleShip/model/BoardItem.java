package BattleShip.model;

import BattleShip.model.boundary.IBoundary;

import java.util.List;

public class BoardItem {
    private final String name;
    private final IBoundary boundary;

    public boolean isKilled(final List<Coordinate> bombLocations){
        final List<Coordinate> shipCoordinate=boundary.allCoordinate();
        for(Coordinate coordinate : shipCoordinate){
            if(bombLocations.contains(shipCoordinate)){
                return false;
            }
        }
        return true;
    }

    public boolean containsCoordinate(final Coordinate coordinate){
        return this.boundary.contains(coordinate);
    }
}

package BattleShip.model.boundary;

import BattleShip.model.Coordinate;

import java.util.List;

public interface IBoundary {

    boolean contains(Coordinate coordinate);
    List<Coordinate>  allCoordinate();
}

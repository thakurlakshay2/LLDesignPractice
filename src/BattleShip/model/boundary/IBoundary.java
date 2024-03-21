package BattleShip.model.boundary;

import java.util.List;

public interface IBoundary {

    boolean contains(Coordinate coordinate);
    List<Coordinate>  allCoordinate();
}

package BattleShip.model.boundary;

import java.util.ArrayList;
import java.util.List;

public class RectangularBoundary implements IBoundary{
    public final Coordinate topLeft;
    public final Coordinate bottomRight;

    @Override
    public List<Coordinate> allCoordinate() {
        List<Coordinate> coordinate=new ArrayList<>();

        for(int i=topLeft.getX();i<=bottomRight.getX();i++){
                for(int j=topLeft.getY();j<bottomRight.getY();j++){
                        coordinate.add(new Coordinate(i,j));
                }
        }

        return coordinate;
    }

    public boolean contains(final Coordinate coordinate){
        return coordinate.getX()>=topLeft.getX() && coordinate.getX()<=bottomRight.getX() && coordinate.getY()>=topLeft.getY() && coordinate.getY()<=bottomRight.getY();
    }
}

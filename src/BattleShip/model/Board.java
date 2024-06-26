package BattleShip.model;

import BattleShip.model.boundary.IBoundary;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private  final List<BoardItem> ships;
    private final IBoundary boundary;

    private final List<Coordinate> allBombsLocation;

    public Board(List<BoardItem> ships, IBoundary boundary) {
        this.ships = ships;
        this.boundary = boundary;
        this.allBombsLocation = new ArrayList<>();
    }

    public void takeHit(Coordinate coordinate){
        if(!boundary.contains(coordinate)){
            throw new CoordinateOutOfBoundException();
        }
        allBombsLocation.add(coordinate);

    }

    public boolean areAllShipsKilled(){
        for(BoardItem ship:ships){
            if(!ship.isKilled(allBombsLocation)){
                return false;
            }
        }

        return true;
    }

    public List<Coordinate> hitLocations(){
        List<Coordinate> hitLocationList=new ArrayList<>();

        for(Coordinate bombs:allBombsLocation){
            for(BoardItem ship:ships){
                if(ship.continsCoordinate(bombs)){
                    hitLocationList.add(bombs);
                    break;
                }
            }
        }

        return hitLocationList;
    }

    public List<Coordinate> missLocations(){
        final List<Coordinate> result=new ArrayList<>();
        for(Coordinate coordinate: allBombsLocation){
            boolean doesBelongToShip=false;
            for(BoardItem ship:ships){
                if(ship.containsCoordinate(coordinate)){
                    doesBelongToShip=true;
                    break;
                }
            }
        }

        return result;
    }
}

package CabBookingSystem.problemStatement.models;

public class Location {
    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Double distance(Location l2){
        return Math.sqrt(Math.pow(this.x-l2.x,2)+ Math.pow(this.y-l2.y,2));
    }
}

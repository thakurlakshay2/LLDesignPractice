package CabBookingSystem.problemStatement;

import CabBookingSystem.problemStatement.controllers.CabsController;
import CabBookingSystem.problemStatement.controllers.RidersController;
import CabBookingSystem.problemStatement.database.CabsManager;
import CabBookingSystem.problemStatement.database.RIdersManager;
import CabBookingSystem.problemStatement.database.TripsManager;
import CabBookingSystem.problemStatement.strategy.CabMatchingStrategy;
import CabBookingSystem.problemStatement.strategy.DefaultCabMatchingStrategy;
import CabBookingSystem.problemStatement.strategy.DefaultPricingStrategy;
import CabBookingSystem.problemStatement.strategy.PricingStrategy;

public class Main {
    public void testCabBookingFlow(){

    }
    public static void main(String[] args) {
        CabsManager cabsManager=new CabsManager();
        RIdersManager rIdersManager=new RIdersManager();

        CabMatchingStrategy cabMatchingStrategy=new DefaultCabMatchingStrategy();
        PricingStrategy pricingStrategy=new DefaultPricingStrategy();

        TripsManager tripsManager=new TripsManager(cabsManager,rIdersManager,cabMatchingStrategy,pricingStrategy);

        CabsController cabsController=new CabsController(cabsManager,tripsManager);
        RidersController ridersController=new RidersController(rIdersManager,tripsManager);

        String r1="r1";
        ridersController.registerRider(r1,"rider 1");
        String r2="r2";
        ridersController.registerRider(r2,"rider 2");

        String r3="r3";
        ridersController.registerRider(r3,"rider 3");

        String r4="r1";  //expected - duplicacy error to be shown
        ridersController.registerRider(r1,"rider 4-1");


        String c1="c1";
        cabsController.registerCab(c1,"cab 1");
        String c2="c2";
        cabsController.registerCab(c2,"cab 2");
        String c3="c3";
        cabsController.registerCab(c3,"cab 3");
        String c4="c4";
        cabsController.registerCab(c4,"cab 4");





    }
}

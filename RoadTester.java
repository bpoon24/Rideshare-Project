import java.util.*;

public class RoadTester {
    public static void main(String[] args) {
        //Creating a new Road
        Road myRoad = new Road();

        //Random generation
        System.out.println();
        System.out.println("Generating stations, cars, and passengers...");
        myRoad.stationgenerator(31);
        myRoad.cargenerator(10, 31);
        myRoad.passengergenerator(40, 31);
        myRoad.revenueinitializer();

        System.out.println(myRoad.getrstations());
        System.out.println(myRoad.getrcars());
        System.out.println(myRoad.getrpassengers());

        //Determining how many times the simulation must run
        ArrayList<Car> myrcars = myRoad.getrcars();
        int numsimulations = myRoad.findmaxcardistance(myrcars);

        System.out.println();
        System.out.println("Running the simulation...");

        //Sends Objects to lower classes for first run
        System.out.println();
        System.out.println("Showing initial positions...");
        myRoad.sendCarsToStations();
        myRoad.sendPassengersToStations();

        myRoad.printstationinfo();

        myRoad.pickupallpassengers();

        //The main loop!
        for(int i = 1; i <= numsimulations; i++){
            System.out.println("Move " + i + " of " + numsimulations + "...");

            myRoad.moveallcars();
            myRoad.dropoffallpassengers();
            myRoad.pickupallpassengers();

            myRoad.printstationinfo();
        }

        System.out.println();
        System.out.println("Average revenue: " + myRoad.calculateaveragerevenue());
    }
}
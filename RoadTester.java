import java.util.*;

public class RoadTester {
    public static void main(String[] args) {
        //Creating a new Road
        Road myRoad = new Road();

        System.out.println("Generating stations, cars, and passengers...");
        myRoad.stationgenerator(5);
        myRoad.cargenerator(2, 5);
        myRoad.passengergenerator(1, 5);

        //Calling findmaxcardistance -- a little tricky
        /*
        ArrayList<Car> myrcars = myRoad.getrcars();
        myRoad.findmaxcardistance(myrcars);
        */

        //Determining how many times the simulation must run
        ArrayList<Car> myrcars = myRoad.getrcars();
        int numsimulations = myRoad.findmaxcardistance(myrcars);

        System.out.println("Running the simulation...");
        for(int i = 1; i <= numsimulations; i++){
            System.out.println("Move " + i + " of " + numsimulations);
            myRoad.moveallcars();
            myRoad.dropoffallpassengers();
            myRoad.pickupallpassengers();
            System.out.println();
        }   
    }
}

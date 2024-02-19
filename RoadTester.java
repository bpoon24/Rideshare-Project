import java.util.*;

public class RoadTester {
    public static void main(String[] args) {
        //Creating a new Road
        Road myRoad = new Road();

        //Non-random generation
        /*
        Station s1 = new Station(1);
        Station s2 = new Station(2);
        Station s3 = new Station(3);

        Car c1 = new Car(1, 3);
        Car c2 = new Car(3, 1);
        Car c3 = new Car (1, 2);

        Passenger p1 = new Passenger(1, 3);
        Passenger p2 = new Passenger(2, 1);
        Passenger p3 = new Passenger(2, 3);
        */

        //Random generation
        System.out.println();
        System.out.println("Generating stations, cars, and passengers...");
        myRoad.stationgenerator(10);
        myRoad.cargenerator(8, 10);
        myRoad.passengergenerator(12, 10);

        System.out.println(myRoad.getrstations());
        System.out.println(myRoad.getrcars());
        System.out.println(myRoad.getrpassengers());

        //Calling findmaxcardistance -- a little tricky
        /*
        ArrayList<Car> myrcars = myRoad.getrcars();
        myRoad.findmaxcardistance(myrcars);
        */

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

        for(int i = 1; i <= numsimulations; i++){
            System.out.println("Move " + i + " of " + numsimulations + "...");

            myRoad.moveallcars();
            myRoad.dropoffallpassengers();
            myRoad.pickupallpassengers();

            myRoad.printstationinfo();

        /*
            System.out.println(s1.sToString());
            System.out.println(s2.sToString());
            System.out.println(s3.sToString());

            System.out.println(c1.cToString());
            System.out.println(c2.cToString());
            System.out.println(c3.cToString());

            System.out.println();
        }   

        System.out.println("Showing final positions...");
        myRoad.dropoffallpassengers();
        myRoad.printstationinfo();
        */
    }
    }

}
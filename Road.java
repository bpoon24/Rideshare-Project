import java.util.*;

public class Road {
    private ArrayList<Passenger> rpassengers;  
    private ArrayList<Car> rcars;
    private ArrayList<Station> rstations;

    public Road(){
        rpassengers = new ArrayList<Passenger>();
        rcars = new ArrayList<Car>();  
        rstations = new ArrayList<Station>();  
    }

    //Randomness generators
    public ArrayList<Station> stationgenerator(int numstations){ //Make numstations whatever you want
        for(int i = 1; i <= numstations; i++){ //Stations start at 1
            Station myStation = new Station(i); //Creates a Station with ID number corresponding to i
            rstations.add(myStation);
        }
        return rstations;
    }

    public ArrayList<Car> cargenerator(int numcars, int numstations){ //Make numcars whatever you want.  numstations must match the stationgenerator parameter.
        for(int i = 0; i < numcars; i++){
            int randomcstart = (int) (Math.random() * (numstations)) + 1; //Generates a random integer from 1 to numstations.
            int randomcend = (int) (Math.random() * (numstations)) + 1;
            Car myCar = new Car(randomcstart, randomcend);
            rcars.add(myCar);
        }
        return rcars;
    }

    public ArrayList<Passenger> passengergenerator(int numpassengers, int numstations){ //Make numpassengers whatever you want.  numstations must match the stationgenerator parameter.
        for(int i = 0; i < numpassengers; i++){
            int randompstart = (int) (Math.random() * (numstations)) + 1; 
            int randompend = (int) (Math.random() * (numstations)) + 1;
            Passenger myPassenger = new Passenger(randompstart, randompend);
            rpassengers.add(myPassenger);            
        }
        return rpassengers;
    }

    //Misc
    public ArrayList<Car> getrcars(){
        return rcars;
    }

    public String toString(){
        for(int i = 1; i <= numstations; i++){
            
        }
    }

    //Helper methods for runner
    public int findmaxcardistance(ArrayList<Car> rcars){ //The max distance is the number of "moves" that need to be called
        int maxdistance = 0;
        int distance = 0;
        for(int i = 0; i < rcars.size(); i++){
            distance = Math.abs(rcars.get(i).getcstart() - rcars.get(i).getcend());
            if(distance > maxdistance){
                maxdistance = distance;
            }
        }
        return maxdistance;
    }

    public void moveallcars(){
        for(int i = 0; i < rcars.size(); i++){
            rcars.get(i).move(); //The move() method is in Car
        }
    }

    public void dropoffallpassengers(){
        for(int i = 0; i < rstations.size(); i++){
            rstations.get(i).dropoff(); //Dropoff() is in Station
        }
    }

    public void pickupallpassengers(){
        for(int i = 0; i < rstations.size(); i++){
            rstations.get(i).pickup(); //Pickup() is in Station
        }        
    }

    //The top level method!
    /*
    public void runner(){
        for(int i = 0; i < findmaxcardistance(rcars); i++){
            moveallcars();
            dropoffallpassengers();
            pickupallpassengers();
            System.out.println();
        }
    }
    */
}
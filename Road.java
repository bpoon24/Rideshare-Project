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
        for(int i = 0; i < numstations; i++){ //Stations start at 0 and end at numstations - 1.
            Station myStation = new Station(i); //Creates a Station with ID number corresponding to i
            rstations.add(myStation);
        }
        return rstations;
    }

    public ArrayList<Car> cargenerator(int numcars, int numstations){ //Make numcars whatever you want.  numstations must match the stationgenerator parameter.
        for(int i = 0; i < numcars; i++){
            int randomcstart = (int) (Math.random() * (numstations)); //Generates a random integer from 1 to numstations.
            int randomcend = (int) (Math.random() * (numstations));
            Car myCar = new Car(randomcstart, randomcend);
            rcars.add(myCar);
        }
        return rcars;
    }

    public ArrayList<Passenger> passengergenerator(int numpassengers, int numstations){ //Make numpassengers whatever you want.  numstations must match the stationgenerator parameter.
        for(int i = 0; i < numpassengers; i++){
            int randompstart = (int) (Math.random() * (numstations)); 
            int randompend = (int) (Math.random() * (numstations));
            Passenger myPassenger = new Passenger(randompstart, randompend);
            rpassengers.add(myPassenger);            
        }
        return rpassengers;
    }

    //Getters
    public ArrayList<Car> getrcars(){
        return rcars;
    }

    public ArrayList<Station> getrstations(){
        return rstations;
    }

    public ArrayList<Passenger> getrpassengers(){
        return rpassengers;
    }

    //Methods that send the randomly generated passengers and cars to "lower" classes
    public void sendCarsToStations(){
        for(int i = 0; i < rstations.size(); i++){ //Loops through all stations
            for(int j = 0; j < rcars.size(); j++){ //Loops through ALL Cars (not just the Cars in Station i)
                if(rcars.get(j).getcstart() == i){ //Checks if Car j starts at Station i
                    rstations.get(i).getscars().add(rcars.get(j)); //Adds Car j to Station i's ArrayList of Cars
                }
            }
        }
    }

    public void sendPassengersToStations(){
        for(int i = 0; i < rstations.size(); i++){ 
            for(int j = 0; j < rpassengers.size(); j++){
                if(rpassengers.get(j).getpstart() == i){
                    rstations.get(i).getspassengers().add(rpassengers.get(j));
                }
            }
        }
    }

    //Big toString
    public void printstationinfo(){
        for(int i = 0; i < rstations.size(); i++){ //Loop through each station
            String info = "";
            info += "STATION #" + rstations.get(i).getsID() + ": ";
            for(int k = 0; k < rstations.get(i).getscars().size(); k++){ //Loop through each car in each station
                info += rstations.get(i).getscars().get(k).cToString();
            }
            for(int j = 0; j < rstations.get(i).getspassengers().size(); j++){ //Loop through each passenger in each station
                info += rstations.get(i).getspassengers().get(j).pToString();
            }
            System.out.println(info);
            System.out.println();
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
            Car mycar = rcars.get(i);
            int oldStationIndex = mycar.getcpos();
            mycar.move(); //The move() method is in Car
            int newStationIndex = mycar.getcpos();

            if(newStationIndex != oldStationIndex){
                rstations.get(newStationIndex).getscars().add(mycar);
                rstations.get(oldStationIndex).getscars().remove(mycar);
            }
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
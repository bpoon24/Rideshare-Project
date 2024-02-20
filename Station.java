import java.util.*;

public class Station {
    private int sID;
    private ArrayList<Passenger> spassengers;  
    private ArrayList<Car> scars;

    public Station(int mysID){
        sID = mysID;
        spassengers = new ArrayList<Passenger>();
        scars = new ArrayList<Car>();
    }

    public String sToString(){
        return "Station " + sID + ": " + "Passengers in this Station: " + spassengers + ", Cars in this Station: " + scars;
    }

    public int getsID(){
        return sID;
    }

    public ArrayList<Passenger> getspassengers(){
        return spassengers;
    }

    public ArrayList<Car> getscars(){
        return scars;
    }

    //Passengers -- actual methods
    public void dropoff(){
        for(int i = 0; i < scars.size(); i++){ //Loops through Cars in Station
            if(scars.get(i).getnumpas() > 0){
                for(int j = scars.get(i).getnumpas() - 1; j >= 0; j--){ //Loops through Passengers in Car.  Backwards b/c removing Passengers decreases the size of the list.
                    Car mycar = scars.get(i);
                    Passenger mypassenger = mycar.getpassenger(j);
                    if((mypassenger.getppos() == mypassenger.getpend()) || (mycar.getcpos() == mycar.getcend())){//Checks whether to drop off or not
                        spassengers.add(mycar.getcpassengers().remove(j));
                        mycar.decreasenumpas();
                    }
                }
            }
        }
    }

    public void pickup(){
        for(int i = 0; i < scars.size(); i++){  //Loops through Cars in Station
            if(spassengers.size() > 0){
                for(int j = spassengers.size() - 1; j >= 0; j--){ //Loops through Passengers in Station.  Backwards b/c removing Passengers decreases the size of the list.
                    Car mycar = scars.get(i);
                    Passenger mypassenger = spassengers.get(j);
                    if((mycar.getnumpas() < 3 && mycar.getcpos() != mycar.getcend())){ //Checks car's capacity
                        if(mypassenger.getpisforward() && mycar.getcisforward()){ //Checks for forward-moving passengers
                            if(sID < mypassenger.getpend()){
                                mycar.caddpassenger(mypassenger);
                                spassengers.remove(mypassenger);
                            }
                        }
                        if(!mypassenger.getpisforward() && !mycar.getcisforward()){ //Checks for backward-moving passengers
                            if(sID > mypassenger.getpend()){
                                mycar.caddpassenger(mypassenger);
                                spassengers.remove(mypassenger);                           
                            }
                        }
                    }
                }
            }
        }
    }


    //Passengers -- very simple methods; may not need
    public void saddpassenger(Passenger mypassenger){
        spassengers.add(mypassenger);
    }

    public void sremovepassenger(Passenger mypassenger){
        spassengers.remove(mypassenger);
    }

    //Cars
    public void saddcar(Car mycar){
        scars.add(mycar);
    }

    public void sremovecar(Car mycar){
        scars.remove(mycar);
    }
}




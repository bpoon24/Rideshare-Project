import java.util.*;

public class Station {
    private static int sIDGen = 0;
    private int sID;
    private ArrayList<Passenger> spassengers;  
    private ArrayList<Car> scars;

    public Station(){
        sID = sIDGen;
        sIDGen++;
        spassengers = new ArrayList<Passenger>();
        scars = new ArrayList<Car>();
    }

    public String sToString(){
        return "Station " + sID;
    }

    //Passengers -- actual methods?
    public void dropoff(){
        for(int i = 0; i < scars.size(); i++){ //Loops through Cars in Station
            for(int j = scars.get(i).getnumpas(); j >= 0; j--){ //Loops through Passengers in Car.  Backwards b/c removing Passengers decreases the size of the list.
                Car mycar = scars.get(i);
                Passenger mypassenger = mycar.getpassenger(j);
                if((mypassenger.getppos() == mypassenger.getpend()) || (mycar.getcpos() == mycar.getcend())){//Checks whether to drop off or not
                    spassengers.add(mycar.getcpassengers().remove(j));
                    mycar.decreasenumpas();
                }

                if((mycar.getcpos() == mycar.getcend())){ //Terminates car if it's at final destination
                    scars.remove(i);
                }
            }
        }
    }

    public void pickup(){
        for(int i = 0; i < scars.size(); i++){  //Loops through Cars in Station
            for(int j = spassengers.size(); j >= 0; j--){ //Loops through Passengers in Station.  Backwards b/c removing Passengers decreases the size of the list.
                Car mycar = scars.get(i);
                Passenger mypassenger = spassengers.get(j);
                if((mycar.getcpassengers().size() < 3)){ //Checks car's capacity
                    if(mypassenger.getpisforward() == mycar.getcisforward() == true){ //Checks for forward-moving passengers
                        if(sID < mypassenger.getpend()){
                            mycar.caddpassenger(mypassenger);
                            spassengers.remove(mypassenger);
                        }
                    }
                    if(mypassenger.getpisforward() == mycar.getcisforward() == false){ //Checks for backward-moving passengers
                        if(sID > mypassenger.getpend()){
                            mycar.caddpassenger(mypassenger);
                            spassengers.remove(mypassenger);                           
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




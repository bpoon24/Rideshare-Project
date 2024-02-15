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

    //Passengers
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



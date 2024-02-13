import java.util.*;

public class Station {
    private static int sIDGen = 0;
    private int sID;
    private ArrayList<Passenger> spassengers;  
    private ArrayList<Car> scar;

    public Station(){
        sID = sIDGen;
        sIDGen++;
        spassengers = new ArrayList<Passenger>();
        scar = new ArrayList<Car>();
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
        scar.add(mycar);
    }

    public void sremovecar(Car mycar){
        scar.remove(mycar);
    }




}



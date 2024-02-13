import java.util.*;

public class Car {
    private static int cIDGen = 0;
    private int cID;
    private int cstart;
    private int cend;
    private boolean isforward;
    private ArrayList<Passenger> passengers;

    public Car(int mycstart, int mycend, boolean myisforward){
        cID = cIDGen;
        cIDGen++; 
        cstart = mycstart;
        cend = mycend;
        isforward = myisforward;
        passengers = new ArrayList<Passenger>();
    }


    
    //Getters
    public String cToString(){
        return "Car " + cID + ": " + "Start = " + cstart + ", " + "End = " + cend + ", " + "isForward = " + isforward + ", " + "Passengers = " + passengers;
    }
    public int getcID(){
        return cID;
    }

    public int getcstart(){
        return cstart;
    }

    public int getcend(){
        return cend;
    }

    public int getdistance(){
        return Math.abs(cend - cstart);
    }



    //Stuff about passengers
    public void addpassenger(Passenger mypassenger){
        passengers.add(mypassenger);
    }

    public void removepassenger(Passenger mypassenger){
        passengers.remove(mypassenger);
    }

    public int getnumpas(){
        return passengers.size();
    }
}

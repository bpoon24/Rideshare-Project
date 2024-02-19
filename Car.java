import java.util.*;

public class Car {
    private static int cIDGen = 1;
    private int cID;
    private int cstart;
    private int cend;
    private int cpos;
    private boolean cisforward;
    private int numpas;
    private ArrayList<Passenger> cpassengers;

    public Car(int mycstart, int mycend){
        cID = cIDGen;
        cIDGen++; 
        cstart = mycstart;
        cend = mycend;
        cpos = mycstart; //The car's initial position is it's starting position
        numpas = 0;
        if(mycstart < mycend){
            cisforward = true;
        } else {
            cisforward = false;
        }
        cpassengers = new ArrayList<Passenger>();
    }



    //Getters
    public String cToString(){
        return "CAR " + cID + "(" + "Start = " + cstart + ", " + "End = " + cend + ", " + "Passengers = " + showPassengers() + "); ";
    }

    public String showPassengers(){
        String passengers = "";
        for(int i = 0; i < cpassengers.size(); i++){
            passengers += "PASSENGER " + cpassengers.get(i).getpID() + ", ";
        }
        return passengers;
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

    public int getdistance(){ //May not need this?
        return Math.abs(cend - cstart);
    }

    public int getcpos(){
        return cpos;
    }

    public boolean getcisforward(){
        return cisforward;
    }

    public ArrayList<Passenger> getcpassengers(){
        return cpassengers;
    }

    public Passenger getpassenger(int index){
        return cpassengers.get(index);
    }

    //Stuff about passengers
    public void caddpassenger(Passenger mypassenger){
        cpassengers.add(mypassenger);
    }

    public void cremovepassenger(Passenger mypassenger){
        cpassengers.remove(mypassenger);
    }

    /*
    public void pickup(Passenger mypassenger){
        if((cpassengers.size() < 3) && (mypassenger.getpisforward() == cisforward)){
            cpassengers.add(mypassenger);
        }
    }

    public void dropoff(Passenger mypassenger){
        if((mypassenger.getppos() == mypassenger.getpend()) || (cpos == cend)) {
            cpassengers.remove(mypassenger);
        }
    }
     */

    public int getnumpas(){
        numpas = cpassengers.size();
        return numpas;
    }

    public int decreasenumpas(){
        numpas--;
        return numpas;
    }

    //Moves cars one station in right direction -- this alone doesn't "move" the Car; it just changes the value of one of its fields
    public void move(){
        if(cpos != cend){
            if(cisforward){
                cpos++;
            }
            if(!cisforward){
                cpos--;
            }
        } else {
            cpos = cend;
        }
    }
}

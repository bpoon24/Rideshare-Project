import java.util.*;

public class Car {
    private static int cIDGen = 0;
    private int cID;
    private int cstart;
    private int cend;
    private int cpos;
    private boolean cisforward;
    private ArrayList<Passenger> cpassengers;

    public Car(int mycstart, int mycend){
        cID = cIDGen;
        cIDGen++; 
        cstart = mycstart;
        cend = mycend;
        cpos = mycstart; //The car's initial position is it's starting position
        if(mycstart < mycend){
            cisforward = true;
        } else {
            cisforward = false;
        }
        cpassengers = new ArrayList<Passenger>();
    }



    //Getters
    public String cToString(){
        return "Car " + cID + ": " + "Start = " + cstart + ", " + "End = " + cend + ", " + "isForward = " + cisforward + ", " + "Passengers = " + cpassengers;
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

    //Don't need a getter method for ArrayLists b/c it's permanent?
    public ArrayList<Passenger> getcpassengers(){
        return cpassengers;
    }

    //Stuff about passengers
    public void caddpassenger(Passenger mypassenger){//Don't need?
        cpassengers.add(mypassenger);
    }

    public void cremovepassenger(Passenger mypassenger){//Don't need?
        cpassengers.remove(mypassenger);
    }

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

    public int getnumpas(){//Don't need?
        return cpassengers.size();
    }

    //Moves cars one station in right direction
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

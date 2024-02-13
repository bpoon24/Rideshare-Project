import java.util.*;

public class Car {
    private static int cIDGen = 0;
    private int cID;
    private int cstart;
    private int cend;
    private int cpos;
    private boolean isforward;
    private ArrayList<Passenger> cpassengers;

    public Car(int mycstart, int mycend, boolean myisforward){
        cID = cIDGen;
        cIDGen++; 
        cstart = mycstart;
        cend = mycend;
        cpos = mycstart; //The car's initial position is it's starting position
        isforward = myisforward;
        cpassengers = new ArrayList<Passenger>();
    }



    //Getters
    public String cToString(){
        return "Car " + cID + ": " + "Start = " + cstart + ", " + "End = " + cend + ", " + "isForward = " + isforward + ", " + "Passengers = " + cpassengers;
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
    public void caddpassenger(Passenger mypassenger){
        cpassengers.add(mypassenger);
    }

    public void cremovepassenger(Passenger mypassenger){
        cpassengers.remove(mypassenger);
    }

    public int getnumpas(){
        return cpassengers.size();
    }

    //Moves cars one station in right direction
    public void move(){
        if(cpos != cend){
            if(isforward){
                cpos++;
            }
            if(!isforward){
                cpos--;
            }
        } else {
            cpos = cend;
        }
    }
}

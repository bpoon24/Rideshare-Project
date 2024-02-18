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
    }
}

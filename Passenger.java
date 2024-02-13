public class Passenger {
    public static int IDGen = 0;
    public int ID;
    public int start;
    public int end;

    public Passenger(int myStart, int myEnd){
        ID = IDGen;
        IDGen++;
        start = myStart;
        end = myEnd;
    }

    public String passengerToString(){
        return "Passenger " + ID + ": " + "Start = " + start + ", " + "End = " + end;
    }
}
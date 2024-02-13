public class Passenger {
    private static int pIDGen = 0;
    private int pID;
    private int pstart;
    private int pend;

    public Passenger(int mypstart, int mypend){
        pID = pIDGen;
        pIDGen++;
        pstart = mypstart;
        pend = mypend;
    }

    public String pToString(){
        return "Passenger " + pID + ": " + "Start = " + pstart + ", " + "End = " + pend;
    }

    public int getpID(){
        return pID;
    }

    public int getpstart(){
        return pstart;
    }

    public int getpend(){
        return pend;
    }

}
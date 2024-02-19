public class Passenger {
    private static int pIDGen = 1;
    private int pID;
    private int pstart;
    private int pend;
    private boolean pisforward;
    private int ppos;

    public Passenger(int mypstart, int mypend){
        pID = pIDGen;
        pIDGen++;
        pstart = mypstart;
        ppos = mypstart;
        pend = mypend;
        if(mypstart < mypend){
            pisforward = true;
        } else {
            pisforward = false;
        }
    }

    public String pToString(){
        return "PASSENGER " + pID + "(" + "Start = " + pstart + ", End = " + pend + "); ";
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

    public int getppos(){
        return ppos;
    }

    public boolean getpisforward(){
        return pisforward;
    }

}
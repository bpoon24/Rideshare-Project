public class Car {
    private static int cIDGen = 0;
    private int cID;
    private int cstart;
    private int cend;

    public Car(int mycstart, int mycend){
        cID = cIDGen;
        cIDGen++; 
        cstart = mycstart;
        cend = mycend;
    }

    public String cToString(){
        return "Car " + cID + ": " + "Start = " + cstart + ", " + "End = " + cend;
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
}

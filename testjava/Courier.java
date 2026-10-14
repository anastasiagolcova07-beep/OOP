package testjava;

public class Currier {
    int distanse;//Растояние
    boolean hasCar;//Есть машина

    public Currier(int distanse, boolean hasCar){
        this.distanse=distanse;
        this.hasCar=hasCar;
    }

    public boolean isArrived(){
        return this.distanse==0;
    }
}

package testjava;

public class Courier {
    int distanse;//Растояние
    boolean hasCar;//Есть машина

    public Courier(int distanse, boolean hasCar){
        this.distanse=distanse;
        this.hasCar=hasCar;
    }

    public boolean isArrived(){
        return this.distanse==0;
    }
}

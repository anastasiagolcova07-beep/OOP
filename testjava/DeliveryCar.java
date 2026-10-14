package testjava;

public class DiliveryCar implements DiliveryType {

    @Override
    public int timeOfDilivery(int distance){
        int speed=60;
        int errorTime=10;
        int time = (distance/speed)+errorTime;
        System.out.println("Ваш заказ будет доставлен в течении ");
        System.out.print(time);
        System.out.println(" минут.");

        return time;
    }
}

package testjava;

public class DeliveryCar implements DeliveryType {

    @Override
    public int timeOfDelivery(int distance){
        int speed=60;
        int errorTime=10;
        int time = (distance/speed)+errorTime;
        System.out.println("Ваш заказ будет доставлен в течении ");
        System.out.print(time);
        System.out.println(" минут.");

        return time;
    }

    @Override
    public int getDeliveryCost() {
        return 300;
    }
}

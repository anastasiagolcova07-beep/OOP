package testjava;

public class DeliveryMan implements DeliveryType {
    
    @Override
    public int timeOfDelivery(int distance){
        int speed=5;
        int errorTime=10;
        int time = (distance/speed)+errorTime;
        System.out.println("Ваш заказ будет доставлен в течении ");
        System.out.print(time);
        System.out.println(" минут.");

        return time;
    }
    @Override
    public int getDeliveryCost() {
        return 100;
    }
}

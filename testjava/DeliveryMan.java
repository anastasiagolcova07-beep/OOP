package testjava;

public class DeliveryMan implements DeliveryType {
    
    @Override
    public int getTimeOfDelivery(int distance){
        int speed=5;
        int errorTime=10;
        int time = (distance/speed)+errorTime;
        System.out.println("Ваш заказ будет доставлен на машине в течение " + time + " минут.");
        return time;
    }
    @Override
    public int getDeliveryCost() {
        return 100;
    }
}

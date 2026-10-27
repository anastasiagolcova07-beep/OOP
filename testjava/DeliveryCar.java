package testjava;

public class DeliveryCar implements DeliveryType {

    @Override
    public int getTimeOfDelivery(int distance){
        int speed=60;
        int errorTime=10;
        int time = (distance/speed)+errorTime;
        System.out.println("Ваш заказ будет доставлен на машине в течение " + time + " минут.");

        return time;
    }

    @Override
    public int getDeliveryCost() {
        return 300;
    }
}

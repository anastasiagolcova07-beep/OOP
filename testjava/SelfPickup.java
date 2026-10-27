package testjava;

public class SelfPickup implements DeliveryType {

    public void delivery(String addres){
        System.out.println("Вы выбрали самовывоз, пожалуйста заберите ваш заказ по адресу: " + addres);
    }

    @Override
    public int getTimeOfDelivery(int distance) {
        System.out.println("Заказ будет готов к выдаче через 20 минут.");
        return 20;
    }

    @Override
    public int getDeliveryCost() {
        return 0; 
    }
}

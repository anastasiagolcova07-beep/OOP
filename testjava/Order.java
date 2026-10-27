package testjava;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int idCounter = 1;
    private final int id;

    private List<Product> productsInOrder = new ArrayList<>();
    private DeliveryType deliveryType;
    private String status = "В обработке";

    private Courier assignedCourier;

    public Order() {
        this.id = idCounter++;
    }

    public int getId() {
        return this.id;
    }

    public void addProduct(Product product) {
        productsInOrder.add(product);
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getStatus() {
        return this.status;
    }

    public void nextStatus() {
        if (this.status.equals("В обработке")) {
            this.status = "Готовиться";
        } 
         else if (this.status.equals("Готовиться")) {
            this.status = "В пути / Готов к выдаче";
        }
        else if (this.status.equals("В пути / Готов к выдаче")) {
            this.status = "Доставлен / Завершен";
            if (this.assignedCourier != null) {
                this.assignedCourier.isBusy = false;
            }
        }
    }

    public boolean isEmpty() {
        return productsInOrder.isEmpty();
    }
    
    public void setAssignedCourier(Courier courier) { this.assignedCourier = courier; }
    
    public Courier getAssignedCourier() { return this.assignedCourier; }
    
    public int calculateProductsCost() {
        int total = 0;
        for (Product product : productsInOrder) {
            total += product.calculateTheCost();
        }
        return total;
    }


    public int calculateTotalCost() {
        int finalCost = calculateProductsCost();
        
        // Если тип доставки выбран, прибавляем её стоимость
        if (deliveryType != null) {
            finalCost += deliveryType.getDeliveryCost();
        }
        
        return finalCost;
    }

    public void printOrderInfo() {
        System.out.println("ИНФОРМАЦИЯ О ЗАКАЗЕ");
        System.out.println("Текущий статус: [" + this.status + "]");
        if (assignedCourier != null) {
            System.out.println("Курьер: " + assignedCourier.name + " (Дистанция: " + assignedCourier.distanse + " м)");
        }
        System.out.println("Количество товаров в корзине: " + productsInOrder.size());
        System.out.println("Стоимость товаров: " + calculateProductsCost() + " руб.");
        if (deliveryType != null) {
            System.out.println("Стоимость доставки: " + deliveryType.getDeliveryCost() + " руб.");
        }
        System.out.println("Итоговая сумма: " + calculateTotalCost() + " руб.");
    }

}

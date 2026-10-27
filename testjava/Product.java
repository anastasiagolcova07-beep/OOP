package testjava;

public class Product {
    int price;//Цена

    public Product (int price){
        this.price=price;
    }

    public int calculateTheCost() {
        return this.price;
    }
}

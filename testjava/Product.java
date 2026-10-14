package testjava;

public class Product {
    int number;//Количество
    int price;//Цена

    public Product (int number, int price){
        this.number=number;
        this.price=price;
    }

    public int calculateTheCost() {
        return (this.number*this.price);
    }
}

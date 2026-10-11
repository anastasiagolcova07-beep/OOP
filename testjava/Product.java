package testjava;

public class Product {
    int number;//Количество
    String name;//Название
    int price;//Цена

    public Product (int number, String name, int price){
        this.number=number;
        this.name=name;
        this.price=price;
    }

    public double calculateTheCost() {
        return (this.number*this.price);
    }
}

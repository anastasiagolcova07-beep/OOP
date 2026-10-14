package testjava;
import java.util.ArrayList;
import java.util.List;
public class BaseData {
    public static final List<Courier> couriers = new ArrayList<>();
    public static final List<Product> products = new ArrayList<>();

    public static void toCreateCourier(){
        Courier alex = new Courier(500, false);
        Courier remi = new Courier(1000, true);
        Courier sasha = new Courier(200, true);
        Courier olga = new Courier(700, false);
        Courier nyusha = new Courier(300, false);

        couriers.add(alex);
        couriers.add(remi);
        couriers.add(sasha);
        couriers.add(olga);
        couriers.add(nyusha);
    }
    public static void toCreateProduct(){
        Product pizza = new Product(100,350);
        Product sushi = new Product(80,1000);
        Product burger = new Product(200,150);
        Product soda = new Product(1000,70);
        Product cake = new Product(30,200);

        products.add(pizza);
        products.add(sushi);
        products.add(burger);
        products.add(soda);
        products.add(cake);
    }

}

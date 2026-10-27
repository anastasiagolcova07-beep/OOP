package testjava;
import java.util.ArrayList;
import java.util.List;
public class BaseData {
    public static final List<Courier> couriers = new ArrayList<>();
    public static final List<Product> products = new ArrayList<>();

    public static void toCreateCourier(){
        Courier alex = new Courier("Alex",500, false, false);
        Courier remi = new Courier("Remi",1000, true, false);
        Courier sasha = new Courier("Sasha",200, true, false);
        Courier olga = new Courier("Olga",700, false, false);
        Courier nyusha = new Courier("Nyusha",300, false, false);

        couriers.add(alex);
        couriers.add(remi);
        couriers.add(sasha);
        couriers.add(olga);
        couriers.add(nyusha);
    }
    public static void toCreateProduct(){
        Product pizza = new Product(350);
        Product sushi = new Product(1000);
        Product burger = new Product(150);
        Product soda = new Product(70);
        Product cake = new Product(200);

        products.add(pizza);
        products.add(sushi);
        products.add(burger);
        products.add(soda);
        products.add(cake);
    }

}

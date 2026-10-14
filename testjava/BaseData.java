package testjava;
public class BaseData {
    public static void toCreateCurrier(String[] args){
        Currier Alex = new Currier(500, false);
        Currier Remi = new Currier(1000, true);
        Currier Sasha = new Currier(200, true);
        Currier Olga = new Currier(700, false);
        Currier Nyusha = new Currier(300, false);
    }
    public static void toCreateProduct(String[] args){
        Product pizza = new Product(100,350);
        Product sushi = new Product(80,1000);
        Product burger = new Product(200,150);
        Product soda = new Product(1000,70);
        Product cake = new Product(30,200);
    }

}

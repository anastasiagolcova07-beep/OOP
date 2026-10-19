package testjava;

import java.util.Scanner;

public class Menu {
    
    private static final Scanner scanner = new Scanner(System.in);

    private static Order currentOrder = null; 

    public static void startMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nГлавное меню:");
            System.out.println("1 - Создать новый заказ");
            System.out.println("2 - Управление текущим заказом");
            System.out.println("3 - Выйти");
            System.out.print("Ваш выбор: ");
            String mainChoice = scanner.nextLine();

            if (mainChoice.equals("3")) {
                System.out.println("До свидания!");
                isRunning = false;
            } 
            else if (mainChoice.equals("1")) {
                createNewOrder();
            } 
            else if (mainChoice.equals("2")) {
                manageCurrentOrder();
            } 
            else {
                System.out.println("Неверный ввод. Пожалуйста, выберите 1, 2 или 3.");
            }
        }
    }

    private static void createNewOrder() {
        currentOrder = new Order();

        System.out.println("\nВыберите продукт (0 для перехода к доставке):");
        System.out.println("1 - Пицца (350 руб), 2 - Суши (1000 руб), 3 - Бургер (150 руб)");
        System.out.println("4 - Газировка (70 рублей), 5 - кусочек тортика (200 рублей)");

        boolean isShopping = true;
        while (isShopping) {

            System.out.print("Введите цифру: ");
            String productChoice = scanner.nextLine();

            if (productChoice.equals("0")) {
                isShopping = false; 
            } 
            else if (productChoice.equals("1")) {
                currentOrder.addProduct(BaseData.products.get(0));
                System.out.println("Пицца добавлена!");
            }
                else if (productChoice.equals("2")) {
                currentOrder.addProduct(BaseData.products.get(1));
                System.out.println("Суши добавлены!");
            } 
            else if (productChoice.equals("3")) {
                currentOrder.addProduct(BaseData.products.get(2));
                System.out.println("Бургер добавлен!");
            }
                else if (productChoice.equals("4")) {
                currentOrder.addProduct(BaseData.products.get(3));
                System.out.println("Газировка добавлена!");
            }
                else if (productChoice.equals("5")) {
                currentOrder.addProduct(BaseData.products.get(4));
                System.out.println("Тортик добавлен!");
            }
                else {
                System.out.println("Такого продукта нет.");
            }
        }

        DeliveryType chosenDelivery = null;
        while (chosenDelivery == null) {
            System.out.println("\nДоставка: 1 - Стандарт, 2 - На машине, 3 - Самовывоз");
            System.out.print("Ваш выбор: ");
            String deliveryChoice = scanner.nextLine();

            if (deliveryChoice.equals("1")) {
                chosenDelivery = new DeliveryMan();
                currentOrder.setDeliveryType(chosenDelivery);
                System.out.print("Введите адрес для пешего курьера: ");
                scanner.nextLine();
            } else if (deliveryChoice.equals("2")) {
                chosenDelivery = new DeliveryCar();
                currentOrder.setDeliveryType(chosenDelivery);
                 System.out.print("Введите адрес для машины: ");
                scanner.nextLine();
            } else if (deliveryChoice.equals("3")) {
                chosenDelivery = new SelfPickup();
                currentOrder.setDeliveryType(chosenDelivery);
                ((SelfPickup) chosenDelivery).delivery("ул. Главная, д. 10");
            } else {
                System.out.println("Неверный выбор.");
            }
        }

        System.out.println("\nЗаказ успешно оформлен и передан в обработку!");
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }

     private static void manageCurrentOrder() {
        if (currentOrder == null) {
            System.out.println("У вас пока нет активных заказов.");
            System.out.print("Нажмите Enter для возврата...");
            scanner.nextLine();
            return; 
        }

        currentOrder.printOrderInfo();

        if (currentOrder.getStatus().equals("Доставлен / Завершен")) {
            System.out.println("Этот заказ уже полностью выполнен.");
            System.out.print("Нажмите Enter для возврата...");
            scanner.nextLine();
        } 
        else {
            System.out.println("Изменить статус?");
            System.out.println("1 - Да, изменить статус");
            System.out.println("2 - Нет, вернуться назад");
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                String oldStatus = currentOrder.getStatus();
                currentOrder.nextStatus();
                System.out.println("Статус успешно изменен с [" + oldStatus + "] на [" + currentOrder.getStatus() + "]");
            } else {
                System.out.println("Возврат в главное меню.");
            }
            System.out.print("Нажмите Enter для продолжения...");
            scanner.nextLine();
        }
    }
}

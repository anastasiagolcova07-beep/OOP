package testjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    
    private static final Scanner scanner = new Scanner(System.in);

    private static Order currentOrder = null; 

    private static final List<Order> ordersList = new ArrayList<>();

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

        if (currentOrder.isEmpty()) {
            System.out.println("\nОшибка: Нельзя оформить заказ без продуктов! Возврат в главное меню.");
            System.out.println("Нажмите Enter для продолжения...");
            scanner.nextLine();
            return;
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

                Courier bestCourier = null;
                for (Courier c : BaseData.couriers) {
                    if (!c.hasCar && !c.isBusy) { 
                        if (bestCourier == null || c.distanse < bestCourier.distanse) {
                            bestCourier = c;
                        }
                    }
                }

                if (bestCourier == null) {
                    System.out.println("Ошибка: Нет свободных пеших курьеров! Пожалуйста, выберите доставку на машине или самовывоз.");
                    continue; 
                }

                chosenDelivery = new DeliveryMan();
                currentOrder.setDeliveryType(chosenDelivery);
                currentOrder.setAssignedCourier(bestCourier);
                bestCourier.isBusy = true;

                System.out.println("На заказ назначен ближайший курьер: " + bestCourier.name);
                chosenDelivery.getTimeOfDelivery(bestCourier.distanse);

            } else if (deliveryChoice.equals("2")) {
                chosenDelivery = new DeliveryCar();
                currentOrder.setDeliveryType(chosenDelivery);
                System.out.print("Введите адрес для машины: ");
                scanner.nextLine();

                Courier bestCourier = null;
                for (Courier c : BaseData.couriers) {
                    if (c.hasCar && !c.isBusy) { 
                        if (bestCourier == null || c.distanse < bestCourier.distanse) {
                            bestCourier = c;
                        }
                    }
                }

                 if (bestCourier == null) {
                    System.out.println("Ошибка: Нет свободных курьеров на машине! Пожалуйста, выберите доставку пешком или самовывоз.");
                    continue; 
                }

                chosenDelivery = new DeliveryCar();
                currentOrder.setDeliveryType(chosenDelivery);
                currentOrder.setAssignedCourier(bestCourier);
                bestCourier.isBusy = true;

                System.out.println("На заказ назначен ближайший курьер на машине: " + bestCourier.name);
                chosenDelivery.getTimeOfDelivery(bestCourier.distanse);
            } else if (deliveryChoice.equals("3")) {
                chosenDelivery = new SelfPickup();
                currentOrder.setDeliveryType(chosenDelivery);
                ((SelfPickup) chosenDelivery).delivery("ул. Главная, д. 10");
                chosenDelivery.getTimeOfDelivery(0);
            } else {
                System.out.println("Неверный выбор.");
            }
        }

        ordersList.add(currentOrder);
        System.out.println("\nЗаказ №" + currentOrder.getId() + " успешно оформлен!");
        System.out.println("Нажмите Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }

     private static void manageCurrentOrder() {
        if (ordersList.isEmpty()) {
            System.out.println("Активных заказов в системе нет.");
            System.out.println("Нажмите Enter для возврата...");
            scanner.nextLine();
            return; 
        }
        System.out.println("\n--- Список ваших заказов ---");
        for (Order o : ordersList) {
            System.out.println("Заказ №" + o.getId() + " [" + o.getStatus() + "]");
        }
        System.out.println("0 - Вернуться назад");
        System.out.print("Введите НОМЕР ЗАКАЗА для работы с ним: ");
        
        String inputIdStr = scanner.nextLine();
        if (inputIdStr.equals("0")) {
            return;
        }

        // Ищем выбранный заказ в списке по его ID
        Order selectedOrder = null;
        for (Order o : ordersList) {
            if (String.valueOf(o.getId()).equals(inputIdStr)) {
                selectedOrder = o;
                break;
            }
        }

        if (selectedOrder == null) {
            System.out.println("Заказ с таким номером не найден.");
            System.out.println("Нажмите Enter...");
            scanner.nextLine();
        } 
        else {
            processOrderSelection(selectedOrder);
        }
    }

    private static void processOrderSelection(Order order) {
        order.printOrderInfo();

        if (order.getStatus().equals("Доставлен / Завершен")) {
            System.out.println("Этот заказ уже полностью выполнен.");
            System.out.println("Нажмите Enter для возврата...");
            scanner.nextLine();
        } 
        else {
            System.out.println("Хотите продвинуть заказ №" + order.getId() + " на следующий этап?");
            System.out.println("1 - Да, изменить статус");
            System.out.println("2 - Нет, вернуться назад");
            
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                String oldStatus = order.getStatus();
                order.nextStatus(); 
                System.out.println("Статус заказа №" + order.getId() + " изменен с [" + oldStatus + "] на [" + order.getStatus() + "]");
            } else {
                System.out.println("Возврат.");
            }
            System.out.println("Нажмите Enter для продолжения...");
            scanner.nextLine();
        }
    }
}

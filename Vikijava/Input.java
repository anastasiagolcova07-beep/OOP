package Vikijava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;


public class Input {
    private final Logger logger = LoggerFactory.getLogger(Input.class);
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getSearch() {
        while (true) {
            logger.info("Введите поисковый запрос для Википедии: ");
            String input = scanner.nextLine();

            if (input != null) {
                input = input.trim();//delete space
            }

            if (input == null || input.isEmpty()) {
                logger.warn("Пользователь ввёл пустой запрос. Повторяем попытку ввода.");
                logger.error("Ошибка: запрос не может быть пустым. Попробуйте ещё раз.\n");
                continue; 
            }

            logger.info("Пользователь успешно ввёл запрос: '{}'", input);
            return input;
        }
    }
}

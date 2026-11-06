package Vikijava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        
        logger.info("Введите 0 для выхода\n");

        Input inputReader = new Input();

        String query = inputReader.getSearch();

        while (!(query.equals("0"))){//query!="0"
            logger.info("Успех! Программа приняла запрос: " + query);
            query = inputReader.getSearch();
        }
        logger.info("\nДо свидания!");
    }
}
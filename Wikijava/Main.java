package Wikijava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        
        logger.info("Введите 0 для выхода\n");

        Input inputReader = new Input();

        String query = inputReader.getSearch();


        while (!(query.equals("0"))){//query!="0"
            logger.debug("Успех! Программа приняла запрос: " + query);

            WikiApi apiClient = new WikiApi();
            String jsonResponse = apiClient.search(query);

            if (jsonResponse != null) {
                logger.debug("\nОтвет с сервера (JSON)");
                logger.debug(jsonResponse);
            } 
            else {
                logger.error("Не удалось получить данные с сервера Википедии.");
            }

            Parse parser = new Parse();
            List<Article> articles = parser.parse(jsonResponse);

            Output outputWriter = new Output();
            outputWriter.printArticles(articles);

            int choice = inputReader.getArticleChoice(articles.size());
            if (choice > 0) {
                Article selectedArticle = articles.get(choice);
                OpenBrowser browser = new OpenBrowser();
                browser.openArticle(selectedArticle.getPageid());
            }

            logger.info("\nВведите 0 для выхода");

            query = inputReader.getSearch();
        }
        logger.info("\nДо свидания!");
    }
}
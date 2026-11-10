package Wikijava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Output {
    private final Logger logger = LoggerFactory.getLogger(Output.class);

    public void printArticles(List<Article> articles) {
        if (articles == null || articles.isEmpty()) {
            logger.info("\nК сожалению, по вашему запросу ничего не найдено.");
            return;
        }

        logger.info("\nРезультаты поиска в Википедии:");

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            logger.info((i + 1) + ". " + article.getTitle());
        }
    }
}

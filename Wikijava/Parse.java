package Wikijava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import java.util.Collections;
import java.util.List;

public class Parse {
    private final Logger logger = LoggerFactory.getLogger(Parse.class);
    private final Gson gson;

    public Parse() {
        this.gson = new Gson();
    }

    public List<Article> parse(String jsonResponse) {
        if (jsonResponse == null || jsonResponse.isEmpty()) {
            logger.warn("На разбор передан пустой ответ от сервера.");
            return Collections.emptyList();
        }

        try {
            logger.debug("Начинаем разбор JSON-ответа...");
            SearchResult result = gson.fromJson(jsonResponse, SearchResult.class);

            if (result == null || result.getQuery() == null || result.getQuery().getSearch() == null) {
                logger.warn("В ответе сервера нет результатов поиска.");
                return Collections.emptyList();
            }

            List<Article> articles = result.getQuery().getSearch();
            logger.debug("Ответ успешно распарсен. Найдено статей: {}", articles.size());
            
            return articles;

        } catch (Exception e) {
            logger.error("Ошибка при парсинге JSON через Gson", e);
            return Collections.emptyList();
        }
    }
}

package Wikijava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WikiApi {
    private final Logger logger = LoggerFactory.getLogger(WikiApi.class);
    private final HttpClient httpClient;

    public WikiApi() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String search(String searchQuery) {
        try {
            logger.info("Отправка поискового запроса к серверу Википедии...");

            String encodedQuery = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
            

            String url = "https://wikipedia.org" + encodedQuery;
            logger.info("Сформирован URL: {}", url);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            logger.info("Ответ от сервера успешно получен. Код статуса: {}", response.statusCode());
            return response.body();

        } 
        catch (Exception e) {//error wifi

            logger.error("Ошибка сети при отправке запроса для: {}", searchQuery, e);
            return null;
        }
    }

}

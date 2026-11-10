package Wikijava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.Desktop;
import java.net.URI;

public class OpenBrowser {
    private final Logger logger = LoggerFactory.getLogger(OpenBrowser.class);

    public void openArticle(int pageId) {
        String url = "https:/ru.wikipedia.org/w/index.php?curid=" + pageId;
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                logger.info("Открываем статью в браузере: {}", url);
                Desktop.getDesktop().browse(new URI(url));
            } 
            else {
                logger.warn("Открытие браузера не поддерживается вашей системой.");
            }
        } 
        catch (Exception e) {
            logger.error("Не удалось открыть ссылку в браузере", e);
        }
    }
}

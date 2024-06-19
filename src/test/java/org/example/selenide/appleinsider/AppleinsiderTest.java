package org.example.selenide.appleinsider;

import org.example.utils.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class AppleinsiderTest extends BaseTest {

    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "Чем iPhone 13 отличается от iPhone 12";
    private final static String EXPECTED_WORD = "iphone-13";

    @Test
    public void checkHref() {
        String hrefFromFirstArticle =
                new AppleinsiderMainPage(BASE_URL)
                .search(SEARCH_STRING)
                .getHrefFromFirstArticle();

        assertNotNull(hrefFromFirstArticle);
        assertTrue(hrefFromFirstArticle.contains(EXPECTED_WORD));
    }
}

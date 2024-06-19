package org.example.wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;

public class WikiTest extends BaseTest {

    private final static String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void openAllHrefs() {
        open(URL);
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();

        // Перебор всех элементов
        //1
        for (int i = 0; i < hrefs.size(); i++) {
            links.add(hrefs.get(i).getAttribute("href"));
        }
        //2
        for (SelenideElement link : hrefs) {
            links.add(link.getAttribute("href"));
        }
        //3
        hrefs.asFixedIterable().stream().forEach(
                link -> links.add(link.getAttribute("href"))
        );

        // Перебор значений из элементов
        // и работа с элементами
        //1
        links.forEach(Selenide::open);
        //2
        for (String listUrl : links) {
            open(listUrl);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

            Assert.assertEquals(listUrl, currentUrl);
        }
        //3
        while (!links.isEmpty()) {
            int randomNumber = new Random().nextInt(links.size());
            open(links.get(randomNumber));
            links.remove(WebDriverRunner.getWebDriver().getCurrentUrl());
        }
        //4
        List<Integer> linksLength = hrefs.asFixedIterable().stream()
                .map(link -> Objects.requireNonNull(link.getAttribute("href")).length())
                .toList();
    }
}










package org.example.selenide.appleinsider;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class AppleinsiderSearchPage {

    private final ElementsCollection articleTitles = $$x("//h2//a");

    public String getHrefFromFirstArticle() {
        return articleTitles.first().attr("href");
    }
}

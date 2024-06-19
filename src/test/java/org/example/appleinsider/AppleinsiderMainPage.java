package org.example.appleinsider;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

// url - https://appleinsider.ru/
public class AppleinsiderMainPage {

    private final SelenideElement textBoxInput = $("input[name='s']");

    public AppleinsiderMainPage(String url) {
        open(url);
    }

    public AppleinsiderSearchPage search(String searchText) {
        textBoxInput.setValue(searchText);
        textBoxInput.sendKeys(Keys.ENTER);
        return new AppleinsiderSearchPage();
    }

}

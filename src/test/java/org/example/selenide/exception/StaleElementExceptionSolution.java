package org.example.selenide.exception;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class StaleElementExceptionSolution {

    ElementsCollection buttons = $$x(".//a[contains(@class,'button')]");

    private void solutionMethod1() {
        for (int i = 0; i < buttons.size() ; i++) {
            buttons.get(i).click();
        }
    }

    private void solutionMethod2() {
        int index = 0;
        for (SelenideElement button : buttons) {
            buttons.get(index).click();
            index++;
        }
    }

    private boolean solutionMethod3(SelenideElement element) {
        try {
            return element.isDisplayed();
        }catch (StaleElementReferenceException e) {
            return false;
        }
    }

    @Test
    public void checkButton() {
        open("https://the-internet.herokuapp.com/challenging_dom");
        $x("//h3").shouldBe(visible);
        //...
    }
}

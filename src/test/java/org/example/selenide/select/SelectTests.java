package org.example.selenide.select;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.*;

public class SelectTests {

    private final String URL = "https://demoqa.com/select-menu";
    private final String OLD_SELECT_MENU = "#oldSelectMenu";
    private final String MULTI_SELECT_MENU = "#cars";

    @BeforeClass
    public void setUpHeadless() {
        Configuration.headless = true;
    }

    @BeforeTest
    public void openUrl() {
        open(URL);
    }

    @Test(testName = "Test select option by index functionality")
    public void testSelectOptionByIndex() {
        SelenideElement select = $(OLD_SELECT_MENU);
        select.selectOption(1);
        assertEquals(select.getSelectedOptionText(), "Blue");
    }

    @Test(testName = "Test select option by text functionality")
    public void testSelectOptionByText() {
        SelenideElement select = $(OLD_SELECT_MENU);
        String optionText = "Blue";
        select.selectOption(optionText);
        assertEquals(select.getSelectedOptionText(), optionText);
    }

    @Test(testName = "Test select option by value functionality")
    public void testSelectOptionByValue() {
        SelenideElement select = $(OLD_SELECT_MENU);
        String optionValue = "1";
        select.selectOptionByValue(optionValue);
        assertEquals(select.getSelectedOptionValue(), optionValue);
    }

    @Test(testName = "Test select option by containing text functionality")
    void testSelectOptionByContainingText() {
        SelenideElement select = $(OLD_SELECT_MENU);
        select.selectOptionContainingText("Pur");
        assertEquals(select.getSelectedOptionText(), "Purple");
    }

    @Test(testName = "Test multiple select option functionality")
    void testMultipleSelect() {
        SelenideElement select = $(MULTI_SELECT_MENU);
        select.selectOption("Saab", "Opel");
        assertTrue(select.getSelectedOptions().texts().containsAll(List.of("Saab", "Opel")));
    }
}

package org.example.helpdesk;

import org.example.utils.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    @FindBy (id = "username")
    private WebElement loginField;

    @FindBy (id = "password")
    private WebElement passwordField;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public TicketsPage authenticate(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new TicketsPage();
    }
}
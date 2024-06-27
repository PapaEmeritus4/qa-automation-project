package org.example.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// url - https://the-internet.herokuapp.com/login
public class HerokuappLoginPage {

    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $x("//button[@class='radius']");
    private final SelenideElement message = $("#flash");

    public HerokuappLoginPage(String url) {
        open(url);
    }

    public void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.shouldBe(Condition.visible).click();
    }

    public String getMessage() {
        return message.getText();
    }
}
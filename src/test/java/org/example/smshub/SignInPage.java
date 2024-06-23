package org.example.smshub;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SignInPage {

    private SelenideElement signInLink = $x("//a[@data-target='#loginModal']");
    private SelenideElement loginField = $x("//input[@id='emailLogin']");
    private SelenideElement passwordField = $x("//input[@id='passLogin']");
    private SelenideElement signInButton = $x("//input[@id='login_input']");

    public void signIn() {
        open("https://smshub.org/en/main");
        signInLink.click();
        loginField.sendKeys("login");
        passwordField.sendKeys("password");
        signInButton.click();

        SelenideElement captcha = $x("//div[@class='recaptcha-checkbox-borderAnimation']");
        captcha.shouldBe(Condition.clickable).click();
    }
}

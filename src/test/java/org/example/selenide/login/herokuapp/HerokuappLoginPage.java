package org.example.selenide.login.herokuapp;



import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

// url - https://the-internet.herokuapp.com/login
public class HerokuappLoginPage {

    public void openLoginPage() {
        open("https://the-internet.herokuapp.com/login");
    }

    public void enterUsername(String username) {
        $("#username").setValue(username);
    }

    public void enterPassword(String password) {
        $("#password").setValue(password);
    }

    public void clickLoginButton() {
        $("button").click();
    }

    public void shouldHaveSuccessMessage() {
        $("#flash")
                .should(exist, visible)
                .shouldHave(text("You logged into a secure area!"));
    }

    public void shoudHaveUnsuccessfulMessage() {
        $("#flash")
                .should(exist, visible)
                .shouldHave(text("Your username is invalid!"));
    }
}
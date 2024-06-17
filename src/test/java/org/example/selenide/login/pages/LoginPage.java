package org.example.selenide.login.pages;

import org.example.selenide.login.model.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static final String URL = "login";

    private final String USERNAME_FIELD = "#userName";
    private final String PASSWORD_FIELD = "#password";
    private final String LOGIN_BUTTON = "#login";

    public LoginResultPage loginToProfile(User user) {
        $(USERNAME_FIELD).setValue(user.username());
        $(PASSWORD_FIELD).setValue(user.password());
        $(LOGIN_BUTTON).click();

        return page(LoginResultPage.class);
    }
}

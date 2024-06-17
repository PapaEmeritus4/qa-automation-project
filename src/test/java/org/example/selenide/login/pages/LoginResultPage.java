package org.example.selenide.login.pages;

import static com.codeborne.selenide.Selenide.$;

public class LoginResultPage {

    private final String USERNAME_VALUE = "#userName-value";

    public String getUsername() {
        return $(USERNAME_VALUE).text();
    }
}

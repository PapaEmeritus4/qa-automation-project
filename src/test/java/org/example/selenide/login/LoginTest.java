package org.example.selenide.login;

import com.codeborne.selenide.Configuration;
import org.example.selenide.login.model.User;
import org.example.selenide.login.pages.LoginPage;
import org.example.selenide.login.pages.LoginResultPage;
import org.example.utils.ConfProperties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {

    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testLoginFunctionality() {
        User user = new User(
                ConfProperties.getProperty("username"),
                ConfProperties.getProperty("password")
        );
        LoginPage loginPage = open(LoginPage.URL, LoginPage.class);
        LoginResultPage resultPage = loginPage.loginToProfile(user);

        assertThat(resultPage.getUsername()).isEqualTo(user.username());
    }
}

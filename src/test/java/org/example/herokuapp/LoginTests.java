package org.example.herokuapp;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests {

    private HerokuappLoginPage herokuappLoginPage;
    private String correctUsername = "tomsmith";
    private String correctPassword = "SuperSecretPassword";

    @BeforeTest
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        herokuappLoginPage = new HerokuappLoginPage();
    }

    @Test
    public void testSuccessfulLogin() {
        herokuappLoginPage.openLoginPage();
        herokuappLoginPage.enterUsername(correctUsername);
        herokuappLoginPage.enterPassword(correctPassword);
        herokuappLoginPage.clickLoginButton();
        herokuappLoginPage.shouldHaveSuccessMessage();
    }

    @Test
    public void testUnsuccessfulLogin() {
        herokuappLoginPage.openLoginPage();
        herokuappLoginPage.enterUsername("random");
        herokuappLoginPage.enterPassword(correctPassword);
        herokuappLoginPage.clickLoginButton();
        herokuappLoginPage.shoudHaveUnsuccessfulMessage();
    }
}
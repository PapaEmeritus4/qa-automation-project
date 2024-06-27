package org.example.herokuapp;

import org.example.utils.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    private HerokuappLoginPage loginPage;

    @Override
    public void setUp() {
        super.setUp();
        loginPage = new HerokuappLoginPage(HerokuappData.LOGIN_PAGE_URL);
    }

    @Test(description = "Test successful login by valid credentials functionality")
    public void testSuccessfulLogin() {
        loginPage.login(HerokuappData.CORRECT_USERNAME, HerokuappData.CORRECT_PASSWORD);

        assertTrue(loginPage.getMessage().contains(HerokuappData.SUCCESS_MESSAGE));
    }

    @Test(description = "Test unsuccessful login by invalid username functionality")
    public void testUnsuccessfulLoginByInvalidUsername() {
        loginPage.login(HerokuappData.INCORRECT_USERNAME, HerokuappData.CORRECT_PASSWORD);

        assertTrue(loginPage.getMessage().contains(HerokuappData.UNSUCCESSFUL_USERNAME_MESSAGE));
    }

    @Test(description = "Test unsuccessful login by invalid password functionality")
    public void testUnsuccessfulLoginByInvalidPassword() {
        loginPage.login(HerokuappData.CORRECT_USERNAME, HerokuappData.INCORRECT_PASSWORD);

        assertTrue(loginPage.getMessage().contains(HerokuappData.UNSUCCESSFUL_PASSWORD_MESSAGE));
    }
}
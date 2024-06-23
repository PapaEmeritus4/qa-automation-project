package org.example.smshub;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ApiUiTest {

    @Test(description = "Test get balance with API and UI functionality")
    public void checkApiAndUiBalance(){
        SignInPage signInPage = new SignInPage();
        signInPage.signIn();
        String balanceApi = new SmsApi().getAccountBalance();
        String balanceUi = new NumberPage().getAccountBalance();
        assertTrue(balanceUi.contains(balanceApi));
    }
}
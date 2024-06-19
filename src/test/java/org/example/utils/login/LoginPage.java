package org.example.utils.login;

public interface LoginPage {

    public void openLoginPage();

    public void enterUsername(String username);

    public void enterPassword(String password);

    public void clickLoginButton();
}
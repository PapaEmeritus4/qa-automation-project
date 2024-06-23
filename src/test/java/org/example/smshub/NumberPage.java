package org.example.smshub;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NumberPage {

    private SelenideElement accountBalanceText = $x("//a[@id='balansUser']");

    public String getAccountBalance(){
        return accountBalanceText.getValue();
    }
}
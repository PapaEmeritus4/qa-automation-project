package org.example.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest {

    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @BeforeMethod
    public void init() {
        setUp();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

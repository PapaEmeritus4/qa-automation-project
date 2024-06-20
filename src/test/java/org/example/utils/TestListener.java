package org.example.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.example.utils.BaseSeleniumTest.driver;

public class TestListener implements ITestListener {

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult result) {
        // if driver var not static or private
//        Object instance = result.getInstance();
//        try {
//            WebDriver driver1 = (WebDriver) instance.getClass().getDeclaredField("driver").get(instance);
//        } catch (IllegalAccessException | NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }

        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png"
                , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        driver.close();
        driver.quit();
    }
}
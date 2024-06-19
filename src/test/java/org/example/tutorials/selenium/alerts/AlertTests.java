package org.example.tutorials.selenium.alerts;

import org.example.utils.ConfProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class AlertTests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test(testName = "Test simple alert functionality")
    public void testSimpleAlert() {
        driver.get("https://demoqa.com/alerts");

        WebElement element = driver.findElement(By.xpath("//button[@id=\"alertButton\"]"));
        element.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();

        assertEquals(alertText, "You clicked a button");
    }

    @Test(testName = "Test confirmation alert functionality")
    public void testConfirmationAlert() {
        driver.get("https://demoqa.com/alerts");

        WebElement element = driver.findElement(By.xpath("//button[@id=\"confirmButton\"]"));
        element.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        WebElement result = driver.findElement(By.id("confirmResult"));

        assertEquals(result.getText(), "You selected Cancel");
    }

    @Test(testName = "Test prompt alert functionality")
    public void testPromptAlert() {
        driver.get("https://demoqa.com/alerts");

        WebElement element = driver.findElement(By.xpath("//button[@id=\"promtButton\"]"));
        element.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String prompt = alert.getText();
        String someText = "Selenium is easy to use!";
        alert.sendKeys(someText);
        alert.accept();

        assertNotNull(prompt);
    }
}




























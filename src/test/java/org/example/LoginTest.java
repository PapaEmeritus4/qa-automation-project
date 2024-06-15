package org.example;

import org.example.utils.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void validateLoginTest() {
        driver.get(ConfProperties.getProperty("url"));

        String username = ConfProperties.getProperty("login");
        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(username);

        String password = ConfProperties.getProperty("password");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        WebElement userNameField = driver.findElement(By.id("userName-value"));
        String userNameValue = userNameField.getText();

        assertEquals(userNameValue, username, "Not valid user name value");
    }
}

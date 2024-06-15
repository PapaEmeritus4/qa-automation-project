package org.example.clicks;

import org.example.utils.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class ClickTests {

    private static WebDriver driver;
    private static Actions actions;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        actions = new Actions(driver);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void doubleClickTest() {
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));

        actions.doubleClick(doubleClickButton).perform();

        WebElement doubleClickConfirmation = driver.findElement(By.xpath("//p[@id=\"doubleClickMessage\"]"));

        assertTrue(doubleClickConfirmation.isDisplayed());
    }

    @Test
    public void rightClickTest() {
        driver.get("https://demoqa.com/buttons");

        WebElement rightClickButton = driver.findElement(By.xpath("//button[@id=\"rightClickBtn\"]"));

        actions.contextClick(rightClickButton).perform();

        WebElement rightClickConfirmation = driver.findElement(By.xpath("//p[@id=\"rightClickMessage\"]"));

        assertTrue(rightClickConfirmation.isDisplayed());
    }

    @Test
    public void leftClickTest() {
        driver.get("https://demoqa.com/buttons");

        WebElement leftClickButton = driver.findElement(By.xpath("//button[text()=\"Click Me\"]"));

        leftClickButton.click();

        WebElement leftClickConfirmation = driver.findElement(By.xpath("//p[@id=\"dynamicClickMessage\"]"));

        assertTrue(leftClickConfirmation.isDisplayed());
    }
}

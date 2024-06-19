package org.example.tutorials.selenium.attribute;


import org.example.utils.ConfProperties;
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

public class AttributeTest {

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
    public void testGettingAttribute() {
        driver.get("https://demoqa.com/links");
        String resultedAttribute = "http://www.w3.org/1999/xhtml";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement linkedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id=\"simpleLink\"]")));
        String attribute = linkedButton.getAttribute("namespaceURI");

        linkedButton.click();

        assertEquals(resultedAttribute, attribute);
    }
}

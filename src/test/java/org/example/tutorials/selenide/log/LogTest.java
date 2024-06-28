package org.example.tutorials.selenide.log;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.*;

public class LogTest {

    private final Supplier<ConditionFactory> WAITER = () -> Awaitility.given()
            .ignoreExceptions()
            .pollInterval(3, TimeUnit.SECONDS)
            .await()
            .dontCatchUncaughtExceptions()
            .atMost(10, TimeUnit.SECONDS);

    @Test
    public void checkLogWithDelay() {
        open("http://85.192.34.140/logdelay/");
        boolean isLogExists = waitLogs("ThreadQA secret message after 5 sec");
        assertTrue(isLogExists);
    }

    @BeforeSuite
    public static void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();

        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        capabilities.setCapability("goog.loggingPrefs", logPrefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 10_000;
        Configuration.pageLoadTimeout = 10_000;
    }

    private boolean waitLogs(String expectMessage) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        AtomicBoolean isLogContains = new AtomicBoolean(false);

        WAITER.get().until(() -> {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            isLogContains.set(logEntries.getAll().stream().anyMatch(x -> x.getMessage().contains(expectMessage)));
            return isLogContains.get();
        });
        return isLogContains.get();
    }

    private void printLogs(LogEntries logEntries) {
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry);
        }
    }
}
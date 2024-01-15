package utils;

import configuration.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FluentWaitHelper {

    public static WebElement waitUntilVisible(final WebDriver webDriver, final By by) {
        final int fluentWaitDuration = Integer.parseInt(Configuration.config().
                getProperty("fluent.wait.duration", "500"));
        final int fluentSleepDuration = Integer.parseInt(Configuration.config().
                getProperty("fluent.sleep.duration", "100"));
        final WebDriverWait webDriverWait =
                new WebDriverWait(webDriver, Duration.of(fluentWaitDuration, ChronoUnit.MILLIS),
                        Duration.of(fluentSleepDuration, ChronoUnit.MILLIS));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

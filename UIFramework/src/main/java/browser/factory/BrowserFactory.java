package browser.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import static configuration.Configuration.config;

public enum BrowserFactory {
    CHROME {
        @Override
        public WebDriver createDriver() {
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-notifications");

            if (config().get("headless") != null && Boolean.TRUE.toString().equals(config().get("headless"))) {
                chromeOptions.addArguments("--headless");
            }

            return chromeOptions;
        }
    };

    public abstract WebDriver createDriver();

    public abstract AbstractDriverOptions<?> getOptions();
}

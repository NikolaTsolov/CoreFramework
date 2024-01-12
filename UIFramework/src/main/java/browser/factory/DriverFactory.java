package browser.factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

import static configuration.Configuration.config;

public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public WebDriver createInstance(String browser) {
        Target target = Target.valueOf(config().getProperty("target").toString().toUpperCase());

        return switch (target) {
            case LOCAL -> BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
            case REMOTE -> createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
        };
    }

    private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", config().get("gridUrl"), config().get("gridPort"));

            remoteWebDriver = new RemoteWebDriver(URI.create(gridURL).toURL(), capability);
        } catch (java.net.MalformedURLException e) {
            logger.error("Grid URL is invalid or Grid is not available");
            logger.error("Browser: {}", capability.getBrowserName(), e);
        } catch (IllegalArgumentException e) {
            logger.error("Browser {} is not valid or recognized", capability.getBrowserName(), e);
        }

        return remoteWebDriver;
    }

    enum Target {
        LOCAL, REMOTE
    }
}

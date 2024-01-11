package unit;

import browser.factory.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SimpleTest {
    @Test
    public void browserFactoryTest() {
        final DriverFactory driverFactory = new DriverFactory();
        final WebDriver webDriver = driverFactory.createInstance("chrome");
        webDriver.get("https://gh-users-search.netlify.app/");
    }
}

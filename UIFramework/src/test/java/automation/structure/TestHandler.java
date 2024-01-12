package automation.structure;

import browser.factory.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.GitWelcomePage;

import static configuration.Configuration.config;

public class TestHandler {
    private WebDriver webDriver;

    private static String DEFAULT_LANDING_PAGE = "https://gh-users-search.netlify.app/";

    @Before
    public void setUpWebDriver() {
        final DriverFactory driverFactory = new DriverFactory();
        this.webDriver = driverFactory.createInstance("chrome");
        webDriver.get(config().getProperty("default.landing.page", DEFAULT_LANDING_PAGE));
    }

    @After
    public void closeWebDriver() {
        if (webDriver != null) {
            webDriver.close();
        }
    }

    protected GitWelcomePage getGitWelcomePage() {
        return new GitWelcomePage(this.webDriver);
    }
}

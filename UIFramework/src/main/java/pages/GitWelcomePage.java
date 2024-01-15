package pages;

import elements.SearchBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FluentWaitHelper;

public class GitWelcomePage {
    private static String DEFAULT_LANDING_PAGE = "https://gh-users-search.netlify.app/";
    private WebDriver webDriver;
    private SearchBar searchBar;

    private String userName;

    public GitWelcomePage(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navigateToPage() {
        webDriver.get(DEFAULT_LANDING_PAGE);
        this.searchBar = new SearchBar(webDriver);
    }

    public void searchForParticularUser(final String userName) {
        this.userName = userName;
        searchBar.fillAndSubmit(userName);
    }

    public void clickFollowButton() {
        WebElement followButton;
        followButton = FluentWaitHelper.waitUntilVisible(webDriver,
                By.xpath("//article/header/a[contains(@href, \"" + userName + "\")]"));
        followButton.click();
    }
}

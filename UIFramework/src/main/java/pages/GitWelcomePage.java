package pages;

import elements.SearchBar;
import org.openqa.selenium.WebDriver;

public class GitWelcomePage {
    private static String DEFAULT_LANDING_PAGE = "https://gh-users-search.netlify.app/";
    private WebDriver webDriver;
    private SearchBar searchBar;

    public GitWelcomePage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        navigateToPage();
        this.searchBar = new SearchBar(webDriver);
    }

    public void navigateToPage() {
        webDriver.get(DEFAULT_LANDING_PAGE);
    }

    public void searchForParticularUser(final String userName) {
        searchBar.fillAndSubmit(userName);
    }
}

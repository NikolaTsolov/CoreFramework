package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBar {
    private WebElement searchInput;
    private WebElement searchButton;

    public SearchBar(final WebDriver webDriver) {
        this.searchInput = webDriver.findElement(By.ByCssSelector.cssSelector("input[data-testid=\"search-bar\"]"));
        this.searchButton = webDriver.findElement(By.ByCssSelector.cssSelector("div[class=\"form-control\"] button[type=\"submit\"]"));
    }

    public void fillTheForm(final String value) {
        searchInput.sendKeys(value);
    }

    public void clickSubmitButton() {
        searchButton.click();
    }

    public void fillAndSubmit(final String value) {
        fillTheForm(value);
        clickSubmitButton();
    }
}

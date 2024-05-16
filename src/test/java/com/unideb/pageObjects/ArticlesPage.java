package com.unideb.pageObjects;

import com.unideb.factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

import static com.unideb.factory.WebDriverFactory.webDriver;

@Component
public class ArticlesPage extends CommonPageObject {
    private static final String ARTICLES_PAGE_URL = "https://wearecommunity.io/articles";

    @FindBy(css = ".evnt-search-filter > input")
    private WebElement articlesSearchBar;
    @FindBy(css = ".evnt-users-row > .evnt-users-column")
    private List<WebElement> cards;
    @FindBy(css = ".evnt-user-card .evnt-user-name")
    private WebElement card;

    public ArticlesPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickArticlesSearchBar() {
        articlesSearchBar.click();
    }
    public void searchFor(String searchTerm) {
        articlesSearchBar.sendKeys(searchTerm + "\n");
    }


    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }
}

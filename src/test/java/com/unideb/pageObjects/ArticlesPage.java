package com.unideb.pageObjects;

import com.unideb.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticlesPage extends CommonPageObject {

    @FindBy(css = ".evnt-text-fields.form-control.evnt-search")
    private WebElement articlesSearchBar;
    @FindBy(css = ".evnt-users-row > .evnt-users-column")
    private List<WebElement> cards;
    @FindBy(css = ".evnt-cards-container.with-sorting .evnt-article-card")
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

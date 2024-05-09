package com.unideb.pageObjects;

import com.unideb.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventsPage extends CommonPageObject {
    public EventsPage(WebDriverFactory factory) {
        super(factory);
    }

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(css = ".evnt-events-row .evnt-events-column .evnt-card-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-events-row .evnt-events-column")
    private List<WebElement> cards;

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }

}


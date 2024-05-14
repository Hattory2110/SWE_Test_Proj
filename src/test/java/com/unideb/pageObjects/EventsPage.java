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
    @FindBy(css = ".evnt-filters-heading-cell:nth-child(3) .evnt-dropdown-filter.show .evnt-filter-menu .evnt-filter-menu-search-wrapper .evnt-text-fields")
    private WebElement locationSearchField;

    @FindBy(css = ".evnt-dropdown-filter #filter_location")
    private WebElement locationFilter;

//    @FindBy(css = "form-check-label group-items")
//    private WebElement locationFieldLabel;

    @FindBy(css = ".evnt-filter-item")
    private WebElement label;


    @FindBy(css = ".evnt-filters-heading-cell:nth-child(3) .evnt-dropdown-filter.show .evnt-filter-menu .evnt-filter-menu-scroll .evnt-filter-menu-items-wrapper")
    private List<WebElement> labels;
    @FindBy(css = ".evnt-events-row .evnt-events-column .evnt-card-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-events-row .evnt-events-column")
    private List<WebElement> cards;

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void searchForLocation(String searchTerm) { locationSearchField.sendKeys(searchTerm);}

    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }

    public WebElement getLabel() {return label;}

    public int getLabelCount() {
        return labels.size();
    }


    public void clickLocationFilter() {
        locationFilter.click();
    }

}


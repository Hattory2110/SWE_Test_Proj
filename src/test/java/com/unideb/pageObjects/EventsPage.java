package com.unideb.pageObjects;

import com.unideb.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EventsPage extends CommonPageObject {
    public EventsPage(WebDriverFactory factory) {super(factory);}

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;
    @FindBy(css = ".evnt-filters-heading-cell:nth-child(3) .evnt-dropdown-filter.show .evnt-filter-menu .evnt-filter-menu-search-wrapper .evnt-text-fields")
    private WebElement locationSearchField;

    @FindBy(css = ".evnt-dropdown-filter #filter_location")
    private WebElement locationFilter;

    @FindBy(css = ".evnt-filter-item")
    private WebElement label;

    @FindBy(css = ".evnt-platform-header a[href].nav-link")
    private List<WebElement> navigationElements;
//    private Map<String, WebElement> navigationMap = new HashMap<String, WebElement>() {{
//        List<String> navigationKeys = Arrays.asList(new String[]{"Communities", "Events", "Calendar", "Videos", "Speakers", "Articles"});
//        for (int index=0; index < navigationKeys.size(); index++) {
//                navigationMap.put(navigationKeys.get(index), navigationElements.get(index));
//            }
//        }
//    };
//    private Map<String, String> URL = new HashMap<String, String>() {
//        {
//            List<String> navigationKeys = Arrays.asList(new String[]{"Communities", "Events", "Calendar", "Videos", "Speakers", "Articles"});
//            URL.put(navigationKeys.get(0) ,"https://wearecommunity.io/communities");
//            URL.put(navigationKeys.get(1) ,"https://wearecommunity.io/events");
//            URL.put(navigationKeys.get(2) ,"https://wearecommunity.io/calendar");
//            URL.put(navigationKeys.get(3) ,"https://wearecommunity.io/videos");
//            URL.put(navigationKeys.get(4) ,"https://wearecommunity.io/speakers");
//            URL.put(navigationKeys.get(5) ,"https://wearecommunity.io/articles");
//        }
//    };

    @FindBy(css = ".evnt-dropdown-filter.show .form-check label")
    private List<WebElement> labels;
    @FindBy(css = ".evnt-dropdown-filter.show .evnt-filter-item-collapse label")
//    @FindBy(css = ".evnt-dropdown-filter.show .evnt-filter-sub-item label")
    private List<WebElement> checkboxes;
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

    public int getLabelCount() {
        return labels.size();
    }

//    public WebElement getNavigationElement(String name) {
//        return navigationMap.get(name);
//    }


    public void clickLocationFilter() {
        locationFilter.click();
    }

    public void checkEachBox() {
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
    }

//    public void clickNavigationPage(String key) {
//        navigationMap.get(key).click();
//    }

//    public String getNavigationPageURL(String key) {
//        return URL.get(key);
//    }
}


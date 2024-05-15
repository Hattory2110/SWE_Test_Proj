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
    @FindBy(css = ".evnt-dropdown-filter.show .evnt-filter-menu .evnt-filter-menu-search-wrapper .evnt-text-fields")
    private WebElement shownFilterSearchBar;

    @FindBy(css = "#filter_location")
    private WebElement locationFilter;

    @FindBy(css = ".evnt-filter-item")
    private WebElement label;

    @FindBy(css = ".evnt-logo")
    private WebElement mainPage;

    @FindBy(css = ".communities-icon")
    private WebElement communitiesButton;

    @FindBy(css = ".events-icon")
    private WebElement eventsButton;

    @FindBy(css = ".calendar-icon")
    private WebElement calendarButton;

    @FindBy(css = ".talks-library-icon")
    private WebElement videosButton;

    @FindBy(css = ".speakers-icon")
    private WebElement speakersButton;

    @FindBy(css = ".articles-icon")
    private WebElement articlesButton;

    @FindBy(css = ".login")
    private WebElement loginButton;

    @FindBy(css = ".evnt-dropdown-filter.show .form-check label")
    private List<WebElement> all_Location_Label;

    @FindBy(css = "[for^=\"filter_speaker_search\"]")
    private List<WebElement> speaker_Label;

    private List<WebElement> community_Label;

    @FindBy(css = "label[for^=filter_location]")
    private List<WebElement> county_Location_label;
    @FindBy(css = ".evnt-events-row .evnt-events-column .evnt-card-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-events-row .evnt-events-column .evnt-event-card")
    private List<WebElement> cards;

    @FindBy(css = ".evnt-toggle-filters-button")
    private WebElement moreFiltersButton;

    @FindBy(css = "#filter_speaker")
    private WebElement speakersFilter;

    public WebElement getFilterSearchBar() {
        return searchField;
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void searchInFilter(String searchTerm) { shownFilterSearchBar.sendKeys(searchTerm);}

    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }

    public int getLabelCount(String type) {
        return switch (type) {
            case "Location" -> all_Location_Label.size();
            case "Speaker" -> speaker_Label.size();
            case "Community" -> community_Label.size();
            default -> 0;
        };
    }

    public void clickLocationFilter() {
        locationFilter.click();
    }

    public void clickMoreFilter() {
        moreFiltersButton.click();
    }

    public void clickSpeakerFilter() {
        speakersFilter.click();
    }

    public void checkEachBox_Location() {
        for (WebElement checkbox : county_Location_label) {
            checkbox.click();
        }
    }
    private String expectedURL;
    public void clickNavigationPage(String key) {
        switch (key) {
            case "Main_page":
                mainPage.click();
                expectedURL = "https://wearecommunity.io/";
                break;
            case "Communities":
                communitiesButton.click();
                expectedURL = "https://wearecommunity.io/communities";
                break;
            case "Events":
                eventsButton.click();
                expectedURL = "https://wearecommunity.io/events";
                break;
            case "Calendar":
                calendarButton.click();
                expectedURL = "https://wearecommunity.io/calendar";
                break;
            case "Videos":
                videosButton.click();
                expectedURL = "https://wearecommunity.io/videos";
                break;
            case "Speakers":
                speakersButton.click();
                expectedURL = "https://wearecommunity.io/speakers";
                break;
            case "Articles":
                articlesButton.click();
                expectedURL = "https://wearecommunity.io/articles";
                break;
            case "Login":
                loginButton.click();
                expectedURL = "https://wearecommunity.io/login?return_url=%2Fevents";
                break;
        }
    }

    public String getNavigationPageURL(String key) {
        return expectedURL;
    }
}


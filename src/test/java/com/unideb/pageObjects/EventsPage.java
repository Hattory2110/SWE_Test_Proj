package com.unideb.pageObjects;

import com.unideb.factory.WebDriverFactory;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EventsPage extends CommonPageObject {
    public EventsPage(WebDriverFactory factory) {super(factory);}

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

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;
    @FindBy(css = ".evnt-dropdown-filter.show .evnt-filter-menu .evnt-filter-menu-search-wrapper .evnt-text-fields")
    private WebElement shownFilterSearchBar;

    @FindBy(css = "#filter_location")
    private WebElement locationFilter;
    @FindBy(css = "label[for^=filter_location]")
    private List<WebElement> county_Location_label;
    @FindBy(css = ".evnt-dropdown-filter.show .form-check label")
    private List<WebElement> all_Location_Label;


    //    @FindBy(css = ".evnt-filter-item")
    //    private WebElement label;
    @FindBy(css = ".evnt-toggle-filters-button")
    private WebElement moreFiltersButton;
    @FindBy(css = "#filter_speaker")
    private WebElement speakersFilter;

    @FindBy(css = "[for^=filter_speaker_search]")
    private List<WebElement> speakers_Label;

    @FindBy(css = "#filter_event_participation_format")
    private WebElement eventFormatFilter;

    @FindBy(css = "[for^=filter_event_participation_format]")
    private List<WebElement> eventFormatCheckboxes;

    @FindBy(css = "#filter_event_status")
    private WebElement eventStatusFilter;

    @FindBy(css = "[for^=filter_event_status]")
    private List<WebElement> eventStatusCheckboxes;

    @FindBy(css = "#filter_language")
    private WebElement eventLanguageFilter;

    @FindBy(css = "[for^=filter_language]")
    private List<WebElement> eventLanguages;


    @FindBy(css = ".nav-item:first-child .nav-link .evnt-tab-counter")
    private WebElement event_UpcomingCards;
    @FindBy(css = ".evnt-events-row .evnt-events-column .evnt-card-wrapper")
    private WebElement event_Card;

    @FindBy(css = ".evnt-tab-content .evnt-event-card")
    private List<WebElement> event_Cards;





    public WebElement getFilterSearchBar() {
        return searchField;
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void searchInFilter(String searchTerm) { shownFilterSearchBar.sendKeys(searchTerm);}

    public int getCardcountOnPage() {
        return event_Cards.size();
////        Optional<Integer> number = Optional.ofNullable(Integer.getInteger());
//        if (event_UpcomingCards.getText().equals('3')) {
//            return 0;
//        } else {
//            return 1;
//        }
    }

    public WebElement getEvent_Card() {
        return event_Card;
    }

    private List<WebElement> community_Label;
    public int getLabelCount(String type) {
        return switch (type) {
            case "Location" -> all_Location_Label.size();
            case "Speaker" -> speakers_Label.size();
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

    public void clickEventFormatFilter() {
        eventFormatFilter.click();
    }

    public void clickEventStatusFilter() {
        eventStatusFilter.click();
    }

    public void clickEventLanguageFilter() {
        eventLanguageFilter.click();
    }

    public void selectEventLanguageFilter(WebElement lang) {
        var index = eventLanguages.indexOf(lang);
        eventLanguages.get(index).click();
    }

    public void selectEventStatusCheckbox(String name) {
        switch (name) {
            case "Free registration is available":
                eventStatusCheckboxes.get(0).click();
                break;
            case "Call for speakers is open":
                eventStatusCheckboxes.get(1).click();
                break;
            case "Voting for talks is open":
                eventStatusCheckboxes.get(2).click();
                break;
        }
    }

    public void selectEventFormatCheckbox(String name) {
        switch(name) {
            case "Online only":
                eventFormatCheckboxes.get(0).click();
                break;
            case "Offline with streaming":
                eventFormatCheckboxes.get(1).click();
                break;
            case "Offline only":
                eventFormatCheckboxes.get(2).click();
                break;
        }
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

//    private Map<String, WebElement> languageMap = new HashMap<String, WebElement>() {{
//        for (WebElement languageElement: eventLanguages) {
//
//        }
//
//        List<String> languages = List.of("Armenian", "Belarusian",
//                "Bulgarian",
//                "Chinese",
//                "Croatian",
//                "Czech",
//                "English",
//                "Georgian",
//                "German",
//                "Hungarian"
//                "Italian"
//                "Kazakh"
//                "Latvian"
//                "Lithuanian"
//                "Mandarin Chinese"
//                "Polish"
//                "Portuguese"
//                "Romanian"
//                "Russian"
//                "Serbian"
//                "Slovak"
//                "Spanish"
//                "Turkish"
//                "Ukrainian"
//                "Uzbek"
//                "Vietnamese");
//
//
//    }
//
//
//
//    }
}


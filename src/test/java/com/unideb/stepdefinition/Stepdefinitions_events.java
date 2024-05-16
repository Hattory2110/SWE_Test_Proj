package com.unideb.stepdefinition;

import com.unideb.factory.WebDriverFactory;
import com.unideb.pageObjects.EventsPage;
import com.unideb.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class Stepdefinitions_events {

    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private HomePage homePage;

    @Autowired
    private EventsPage eventsPage;

    @And("I type {string} in search on Events Page")
    public void iTypeInSearchEvents(String searchString) {
        eventsPage.searchFor(searchString);
    }
    @Then("I see the {string} card on Events Page")
    public void iSeeTheCardEvents(String title) {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(eventsPage.getEvent_Card(), title));
    }

    @Then("I see {int} card on Events")
    public void iSeeCard_countCardOnEvents(int count) {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBe(By.ByCssSelector.cssSelector(".evnt-events-row .evnt-events-column"), count));
        Assert.assertEquals(count, eventsPage.getCardcountOnPage());
    }

    @And("I type {string} in filter search")
    public void iTypeInLocationSearch(String searchString) {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(eventsPage.getFilterSearchBar()));
        eventsPage.searchInFilter(searchString);
    }

    @Then("I see {int} {string} label")
    public void iSeeLabel_numTypeLabel(int count, String type) {
        Assert.assertEquals(count, eventsPage.getLabelCount(type));
    }

    @And("I click the Location filter")
    public void iClickTheLocationFilter() { eventsPage.clickLocationFilter();}

    @Then("I select each location filter")
    public void iSelectEachLocationFilter() {
        eventsPage.checkEachBox_Location();
    }

    @When("I click on {string} navigation")
    public void iClickOnNavigation(String pageName) {
        eventsPage.clickNavigationPage(pageName);
    }

    @Then("the required {string} opens")
    public void theRequiredOpens(String pageName) {
        Assert.assertTrue(webDriverFactory.getInstance().getPageSource().contains(eventsPage.getNavigationPageURL(pageName)));
    }

    @When("I click on More Filters")
    public void iClickOnMoreFilters() {
        eventsPage.clickMoreFilter();
    }

    @And("I click the Speaker filter")
    public void iClickTheSpeakerFilter() {
        eventsPage.clickSpeakerFilter();
    }

    @And("I select each Speaker filter")
    public void iSelectEachSpeakerFilter() {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(eventsPage.getFilterSearchBar()));
        eventsPage.clickSpeakerFilter();
    }

    @And("I click on Event format")
    public void iClickOnEventFormat() {
        eventsPage.clickEventFormatFilter();
    }

    @And("I select {string} format filter")
    public void iSelectFilter(String type) {
        eventsPage.selectEventFormatCheckbox(type);
    }

    @And("I click on Event status")
    public void iClickOnEventStatus() {
        eventsPage.clickEventStatusFilter();
    }

    @And("I select {string} status filter")
    public void iSelectStatusFilter(String type) {
        eventsPage.selectEventStatusCheckbox(type);
    }

    @And("I click Language filter")
    public void iClickLanguageFilter() {
        eventsPage.clickEventLanguageFilter();
    }

    @And("I select {string} language")
    public void iSelectLanguage(String language) {
        By selector = By.cssSelector(String.format("label[data-value=\"%s\"]", language));
        WebElement languageLabel = webDriverFactory.getInstance().findElement(selector);
        eventsPage.selectEventLanguageFilter(languageLabel);
    }
}

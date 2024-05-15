package com.unideb.stepdefinition;

import com.unideb.factory.WebDriverFactory;
import com.unideb.pageObjects.CommunitiesPage;
import com.unideb.pageObjects.EventsPage;
import com.unideb.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
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
    private CommunitiesPage communitiesPage;

    @Autowired
    private EventsPage eventsPage;

    @Given("the communities portal is opened")
    public void communitiesPortalOpened() {
        webDriverFactory.getInstance().get("https://wearecommunity.io/");
    }

    @Given("the events page opened")
    public void theEventsPageOpened() {
        webDriverFactory.getInstance().get("https://wearecommunity.io/events");
    }

    @When("I click the communities button")
    public void iClickTheCommunitiesButton() {
        homePage.clickCommunities();
    }

    @When("I click the events button")
    public void iClickTheEventsButton() {
        homePage.clickEvents();
    }

    @And("I type {string} in search")
    public void iTypeInSearch(String searchString) {
        communitiesPage.searchFor(searchString);
    } ///Communities

    @Then("I see the {string} card")
    public void iSeeTheCard(String title) {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(communitiesPage.getCard(), title));
    }

    @And("I see {int} card")
    public void iSeeCard(int count) {
        Assert.assertEquals(count, communitiesPage.getCardcountOnPage());
    } //Communities

    @And("I type {string} in search on Events Page")
    public void iTypeInSearchEvents(String searchString) {
        eventsPage.searchFor(searchString);
    }
    @Then("I see the {string} card on Events Page")
    public void iSeeTheCardEvents(String title) {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(eventsPage.getCard(), title));
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
}

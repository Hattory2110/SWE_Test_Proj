package com.unideb.stepdefinition;

import com.unideb.factory.WebDriverFactory;
import com.unideb.pageObjects.CommunitiesPage;
import com.unideb.pageObjects.EventsPage;
import com.unideb.pageObjects.HomePage;
import com.unideb.pageObjects.SpeakersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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
public class StepDefinitions {

    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private HomePage homePage;
    @Autowired
    private SpeakersPage speakersPage;

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
    }

    @Then("I see the {string} card")
    public void iSeeTheCard(String title) {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(communitiesPage.getCard(), title));
    }

    @And("I see {int} card")
    public void iSeeCard(int count) {
        Assert.assertEquals(count, communitiesPage.getCardcountOnPage());
    }

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

    @And("I type {string} in location search")
    public void iTypeInLocationSearch(String searchString) {
        eventsPage.searchForLocation(searchString);
    }

    @And("I see {int} label")
    public void iSeeCountLabel(int count) {
        Assert.assertEquals(count, eventsPage.getLabelCount());
    }

    @And("I click the Location filter")
    public void iClickTheLocationFilter() { eventsPage.clickLocationFilter();}

    @Then("I select each filter")
    public void iSelectEachFilter() {
        eventsPage.checkEachBox();
    }

    @When("I click on {string} navigation")
    public void iClickOnNavigation(String pageName) {
        eventsPage.clickNavigationPage(pageName);
    }

    @Then("the required {string} opens")
    public void theRequiredOpens(String pageName) {
        Assert.assertTrue(webDriverFactory.getInstance().getPageSource().contains(eventsPage.getNavigationPageURL(pageName)));
    }

    @Given("the speakers portal is opened")
    public void theSpeakersPortalIsOpened() {
        webDriverFactory.getInstance().get("https://wearecommunity.io/speakers");
    }

    @When("I click the speakers search bar")
    public void iClickTheSpeakersSearchBar() {
        speakersPage.clickSpeakerSearchBar();
    }

    @And("I type {string} in speakers search")
    public void iTypeInSpeakersSearch(String str) {
        speakersPage.searchFor(str);
    }

    @Then("I see {int} speaker cards")
    public void iSeeCountSpeakerCards(int count) {
            Assert.assertEquals(count, speakersPage.getCardcountOnPage());
    }

    @Then("I see the {string} card on Speakers Page")
    public void iSeeTheCardOnSpeakersPage(String title) {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(1))
                .until(ExpectedConditions.textToBePresentInElement(speakersPage.getCard(), title));
    }

    @When("I click the tags search Button")
    public void iClickTheTagsSearchButton() {
        speakersPage.clickTagsButton();
    }

    @Then("I click into the tags search Bar")
    public void iClickIntoTheTagsSearchBar() {
        speakersPage.clickTagsSearchBar();
    }

    @And("I type {string} in tags search")
    public void iTypeInTagsSearch(String str) {
        speakersPage.searchForTag(str);
    }

    @Then("I see the {string} label on Speakers Page")
    public void iSeeTheLabelOnSpeakersPage(String str) {
        new WebDriverWait(webDriverFactory.getInstance(), Duration.ofSeconds(1))
                .until(ExpectedConditions.textToBePresentInElement(speakersPage.getLabel(), str));
    }
}

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
    private CommunitiesPage communitiesPage;

    @Autowired
    private EventsPage eventsPage;

    @Given("the communities portal is opened")
    public void communitiesPortalOpened() {
        webDriverFactory.getInstance().get("https://wearecommunity.io/");
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

    @And("I see {int} card on Events Page")
    public void iSeeCardEvents(int count) {
        Assert.assertEquals(count, eventsPage.getCardcountOnPage());
    }

    @And("I type {string} in location search")
    public void iTypeInLocationSearch(String searchString) {
        eventsPage.searchForLocation(searchString);
    }

    @Then("I see {int} label")
    public void iSeeCountLabel(int count) {
        Assert.assertEquals(count, eventsPage.getLabelCount());
    }

    @And("I click the Location filter")
    public void iClickTheLocationFilter() { eventsPage.clickLocationFilter();}

    @And("I see {int} card in Events")
    public void iSeeCountCardInEvents(int count) {
        Assert.assertEquals(count, eventsPage.getCardcountOnPage());
    }
}

package com.unideb.pageObjects;

import com.unideb.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

//Ez egy kényelmi funkció, hogy ne kelljen mindig példányosítani
@Component
public class HomePage extends CommonPageObject {
    private static final String HOME_PAGE_URL = "https://wearecommunity.io/";

    @FindBy(className = "communities-icon")
    private WebElement communitiesButton;

    @FindBy(className = "events-icon")
    private WebElement eventsButton;

    public HomePage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickCommunities() {
        communitiesButton.click();
    }

    public void clickEvents() {
        eventsButton.click();
    }
}

package com.unideb.pageObjects;

import com.unideb.factory.WebDriverFactory;
import org.openqa.selenium.support.PageFactory;

public class CommonPageObject {

    public CommonPageObject(final WebDriverFactory factory) {
        PageFactory.initElements(factory.getInstance(), this);
    }
}

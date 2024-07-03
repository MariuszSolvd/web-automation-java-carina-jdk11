package com.solvd.app;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BrowserPageBase extends AbstractPage {

    public BrowserPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void openNewTab();

    public abstract void openTabsContext();
}

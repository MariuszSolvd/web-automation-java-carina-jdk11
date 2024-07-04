package com.solvd.app.ios;

import com.solvd.app.BrowserPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BrowserPageBase.class)
public class BrowserPageIOs extends BrowserPageBase {

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"TabOverviewButton\"]")
    private ExtendedWebElement tabButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"NewTabButton\"]")
    private ExtendedWebElement addNewTabButton;

    public BrowserPageIOs(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openNewTab() {
        tabButton.click();
        addNewTabButton.click();
    }

    @Override
    public void openTabsContext() {
        tabButton.click();
    }
}

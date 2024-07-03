package com.solvd.app.android;

import com.solvd.app.BrowserPageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BrowserPageBase.class)
public class BrowserPageAndroid extends BrowserPageBase implements IAndroidUtils {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Switch or close tabs\"]")
    private ExtendedWebElement tabButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"New tab\"]")
    private ExtendedWebElement addNewTabButton;

    public BrowserPageAndroid(WebDriver driver) {
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

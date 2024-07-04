package com.solvd.pages.common.admin;

import com.solvd.pages.common.PageWithLeftMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractAdminPage extends PageWithLeftMenuBase {
    @FindBy(xpath = "//div[@role = 'rowgroup']")
    protected ExtendedWebElement contentAdminContainer;

    public AbstractAdminPage(WebDriver driver, String url) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setPageAbsoluteURL(url);
        setUiLoadedMarker(contentAdminContainer);
    }
}

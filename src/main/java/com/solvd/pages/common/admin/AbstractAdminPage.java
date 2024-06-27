package com.solvd.pages.common.admin;

import com.solvd.pages.common.AbstractPageWithLeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractAdminPage extends AbstractPageWithLeftMenu {
    @FindBy(xpath = "//div[@class = 'orangehrm-container']/*")
    protected ExtendedWebElement contentAdminContainer;

    public AbstractAdminPage(WebDriver driver, String url) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setPageAbsoluteURL(url);
        setUiLoadedMarker(contentAdminContainer);
    }
}

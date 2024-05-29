package com.solvd.pages.desktop.admin;

import com.solvd.pages.desktop.AbstractPageWithLeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractAdminPage extends AbstractPageWithLeftMenu {
    @FindBy(xpath = "//div[@class = 'orangehrm-container']")
    protected ExtendedWebElement contentAdminContainer;

    public AbstractAdminPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(contentAdminContainer);
    }
}

package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class DashboardPageBase extends PageWithLeftMenuBase {
    @FindBy(xpath = "//div[@class = 'orangehrm-attendance-card']")
    private ExtendedWebElement attendanceCard;

    public DashboardPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(attendanceCard);
    }
}

package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class DashboardPageBase extends AbstractPageWithLeftMenu {
    @FindBy(xpath = "//div[@class='emp-attendance-chart']")
    private ExtendedWebElement attendanceChart;

    public DashboardPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(attendanceChart);
    }
}

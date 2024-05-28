package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends AbstractPageWithLeftMenu {
    @FindBy(xpath = "//div[@class='emp-attendance-chart']")
    private ExtendedWebElement attendanceChart;

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
        setUiLoadedMarker(attendanceChart);
    }

}

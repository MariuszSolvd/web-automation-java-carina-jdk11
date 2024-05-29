package com.solvd.pages.desktop;

import com.solvd.pages.common.DashboardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DashboardPageBase.class)
public class DashboardPage extends DashboardPageBase {
    @FindBy(xpath = "//div[@class='emp-attendance-chart']")
    protected ExtendedWebElement attendanceChart;

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
        setUiLoadedMarker(attendanceChart);
    }

}

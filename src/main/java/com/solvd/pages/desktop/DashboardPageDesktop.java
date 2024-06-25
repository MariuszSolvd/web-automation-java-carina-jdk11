package com.solvd.pages.desktop;

import com.solvd.pages.common.DashboardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DashboardPageBase.class)
public class DashboardPageDesktop extends DashboardPageBase {

    public DashboardPageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }
}

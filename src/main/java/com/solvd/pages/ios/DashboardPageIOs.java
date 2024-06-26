package com.solvd.pages.ios;

import com.solvd.pages.common.DashboardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPageIOs extends DashboardPageBase {

    public DashboardPageIOs(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }
}

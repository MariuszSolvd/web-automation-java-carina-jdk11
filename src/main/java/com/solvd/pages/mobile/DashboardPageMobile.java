package com.solvd.pages.mobile;

import com.solvd.pages.common.DashboardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPageMobile extends DashboardPageBase {

    public DashboardPageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }

}

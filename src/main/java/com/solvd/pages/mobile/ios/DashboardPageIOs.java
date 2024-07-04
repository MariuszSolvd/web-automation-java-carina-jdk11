package com.solvd.pages.mobile.ios;

import com.solvd.pages.common.DashboardPageBase;
import com.solvd.pages.mobile.DashboardPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPageIOs extends DashboardPageMobile {

    public DashboardPageIOs(WebDriver driver) {
        super(driver);
    }

}

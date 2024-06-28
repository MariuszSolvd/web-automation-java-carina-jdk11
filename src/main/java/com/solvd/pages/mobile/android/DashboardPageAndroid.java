package com.solvd.pages.mobile.android;

import com.solvd.pages.common.DashboardPageBase;
import com.solvd.pages.mobile.DashboardPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPageAndroid extends DashboardPageMobile {

    public DashboardPageAndroid(WebDriver driver) {
        super(driver);
    }

}

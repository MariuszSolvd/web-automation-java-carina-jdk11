package com.solvd.pages.mobile.android;

import com.solvd.pages.common.PageWithLeftMenuBase;
import com.solvd.pages.mobile.PageWithLeftMenuBaseMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PageWithLeftMenuBase.class)
public class PageWithLeftMenuAndroid extends PageWithLeftMenuBaseMobile {

    public PageWithLeftMenuAndroid(WebDriver driver) {
        super(driver);
    }
}

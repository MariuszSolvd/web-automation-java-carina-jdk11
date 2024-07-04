package com.solvd.pages.mobile.android.admin;

import com.solvd.pages.common.admin.AdminPageBase;
import com.solvd.pages.mobile.admin.AdminPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AdminPageBase.class)
public class AdminPageAndroid extends AdminPageMobile {

    public AdminPageAndroid(WebDriver webDriver) {
        super(webDriver);
    }

}

package com.solvd.pages.mobile.ios.admin;

import com.solvd.pages.common.admin.AdminPageBase;
import com.solvd.pages.mobile.admin.AdminPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AdminPageBase.class)
public class AdminPageIOs extends AdminPageMobile {

    public AdminPageIOs(WebDriver webDriver) {
        super(webDriver);
    }


}

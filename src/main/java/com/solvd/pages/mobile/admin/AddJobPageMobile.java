package com.solvd.pages.mobile.admin;


import com.solvd.pages.common.admin.AddJobPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddJobPageBase.class)
public class AddJobPageMobile extends AddJobPageBase {

    public AddJobPageMobile(WebDriver webDriver) {
        super(webDriver);
    }
}

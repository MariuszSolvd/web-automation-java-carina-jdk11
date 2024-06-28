package com.solvd.pages.mobile.android.admin;


import com.solvd.pages.common.admin.AddJobPageBase;
import com.solvd.pages.mobile.admin.AddJobPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddJobPageBase.class)
public class AddJobPageAndroid extends AddJobPageMobile {

    public AddJobPageAndroid(WebDriver webDriver) {
        super(webDriver);
    }
}

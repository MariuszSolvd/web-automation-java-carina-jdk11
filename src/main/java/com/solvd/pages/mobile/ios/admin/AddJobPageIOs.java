package com.solvd.pages.mobile.ios.admin;


import com.solvd.pages.common.admin.AddJobPageBase;
import com.solvd.pages.mobile.android.admin.AddJobPageAndroid;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddJobPageBase.class)
public class AddJobPageIOs extends AddJobPageAndroid {

    public AddJobPageIOs(WebDriver webDriver) {
        super(webDriver);
    }
}

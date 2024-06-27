package com.solvd.pages.ios.admin;


import com.solvd.pages.common.admin.AddJobPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddJobPageBase.class)
public class AddJobPageIOs extends AddJobPageBase {

    public AddJobPageIOs(WebDriver webDriver) {
        super(webDriver);
    }
}

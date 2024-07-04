package com.solvd.pages.mobile.android.pim;

import com.solvd.pages.common.pim.EmployeePageBase;
import com.solvd.pages.mobile.pim.EmployeePageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EmployeePageBase.class)
public class EmployeePageAndroid extends EmployeePageMobile {

    public EmployeePageAndroid(WebDriver driver) {
        super(driver);
    }

}

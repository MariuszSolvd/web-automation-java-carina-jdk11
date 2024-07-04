package com.solvd.pages.mobile.ios.pim;

import com.solvd.pages.common.pim.EmployeePageBase;
import com.solvd.pages.mobile.pim.EmployeePageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = EmployeePageBase.class)
public class EmployeePageIOs extends EmployeePageMobile {

    public EmployeePageIOs(WebDriver driver) {
        super(driver);
    }

}

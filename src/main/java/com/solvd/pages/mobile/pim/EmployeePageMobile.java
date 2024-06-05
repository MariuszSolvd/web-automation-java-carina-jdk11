package com.solvd.pages.mobile.pim;

import com.solvd.pages.common.pim.EmployeePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EmployeePageBase.class)
public class EmployeePageMobile extends EmployeePageBase {
    public EmployeePageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }
}

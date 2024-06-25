package com.solvd.pages.mobile.admin;

import com.solvd.pages.common.admin.AdminPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AdminPageBase.class)
public class AdminPageMobile extends AdminPageBase {

    public AdminPageMobile(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }
}

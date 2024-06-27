package com.solvd.pages.ios.admin;

import com.solvd.pages.common.admin.AdminPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AdminPageBase.class)
public class AdminPageIOs extends AdminPageBase {

    public AdminPageIOs(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }
}

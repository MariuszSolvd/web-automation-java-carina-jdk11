package com.solvd.pages.desktop.admin;

import com.solvd.pages.common.admin.AdminPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AdminPageBase.class)
public class AdminPageDesktop extends AdminPageBase {

    public AdminPageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }
}

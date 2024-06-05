package com.solvd.pages.desktop.pim;

import com.solvd.pages.common.pim.EmployeePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = EmployeePageBase.class)
public class EmployeePageDesktop extends EmployeePageBase {

    public EmployeePageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }

}

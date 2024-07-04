package com.solvd.pages.desktop.pim;

import com.solvd.pages.common.pim.EmployeePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = EmployeePageBase.class)
public class EmployeePageDesktop extends EmployeePageBase {

    public EmployeePageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getFirstNameText() {
        return getValueWrapper(firstNameField);
    }

    @Override
    public String getMiddleNameText() {
        return getValueWrapper(middleNameField);
    }

    @Override
    public String getLastNameText() {
        return getValueWrapper(lastNameField);
    }

    @Override
    public String getIdEmployeeText() {
        return getValueWrapper(idEmployeeField);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }

    @Override
    public void getMenuByClick() {
        throw new NotImplementedException("Not implemented for desktop");
    }

    private String getValueWrapper(ExtendedWebElement element) {
        return element.getAttribute("value");
    }
}

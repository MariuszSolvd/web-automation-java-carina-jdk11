package com.solvd.pages.mobile.pim;

import com.solvd.pages.common.pim.EmployeePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EmployeePageBase.class)
public class EmployeePageMobile extends EmployeePageBase {
    public EmployeePageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getFirstNameText() {
        return getValueFromElement(firstNameField.getElement());
    }

    @Override
    public String getMiddleNameText() {
        return getValueFromElement(middleNameField.getElement());
    }

    @Override
    public String getLastNameText() {
        return getValueFromElement(lastNameField.getElement());
    }

    @Override
    public String getIdEmployeeText() {
        return getValueFromElement(idEmployeeField.getElement());
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }

    private String getValueFromElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        return (String) js.executeScript("return arguments[0].value;", element);
    }
}

package com.solvd.pages.mobile.pim;

import com.solvd.pages.common.pim.EmployeePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public abstract class EmployeePageMobile extends EmployeePageBase {

    public EmployeePageMobile(WebDriver webDriver) {
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
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }

    @Override
    public void getMenuByClick() {
        menuButton.click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(leftMenu.getBy()), 30);
    }

    private String getValueWrapper(ExtendedWebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        return (String) js.executeScript("return arguments[0].value;", element.getElement());
    }
}

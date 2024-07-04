package com.solvd.pages.desktop.pim;

import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AddEmployeePageBase.class)
public class AddEmployeePageDesktop extends AddEmployeePageBase {

    public AddEmployeePageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }

    @Override
    protected void inputIdEmployee(String id) {
        idEmployeeField.click();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value='';", idEmployeeField.getElement());
        idEmployeeField.type(id);
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    public void getMenuByClick() {
        throw new NotImplementedException("Not implemented for desktop");
    }
}

package com.solvd.pages.desktop.pim;

import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.solvd.pages.common.pim.PimPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PimPageBase.class)
public class PimPageDesktop extends PimPageBase {

    public PimPageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }

    @Override
    public void clickSearchEmployeeButton() {
        searchEmployeeButton.click();
    }

    @Override
    public void inputIdEmployee(String id) {
        idEmployeeField.click();
        //Is it only one way,  that works in Carina since method clear() is not implemented??
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value='';", idEmployeeField.getElement());
        idEmployeeField.type(id);
    }

    @Override
    public void clickDeleteConfirmationButton() {
        deleteConfirmationButton.click();
    }
}

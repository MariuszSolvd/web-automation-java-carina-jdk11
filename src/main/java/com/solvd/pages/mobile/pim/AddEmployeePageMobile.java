package com.solvd.pages.mobile.pim;

import com.solvd.model.Employee;
import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.solvd.pages.common.pim.EmployeePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public abstract class AddEmployeePageMobile extends AddEmployeePageBase {

    public AddEmployeePageMobile(WebDriver webDriver) {
        super(webDriver);
    }

    protected void inputIdEmployee(String id) {
        waitUntil(ExpectedConditions.elementToBeClickable(idEmployeeField), 20);
        idEmployeeField.click();
        idEmployeeField.click();
        deleteId();
        idEmployeeField.type(id);
    }

    @Override
    public EmployeePageBase addEmployee(Employee employee) {
        inputFirstName(employee.getFirstName());
        inputMiddleName(employee.getMiddleName());
        inputLastName(employee.getLastName());
        inputIdEmployee(employee.getIdEmployee());
        clickSaveButton();
        return initPage(getDriver(), EmployeePageBase.class);
    }

    @Override
    public void getMenuByClick() {
        menuButton.click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(leftMenu.getBy()), 30);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }

    protected abstract void deleteId();
}

package com.solvd.pages.mobile.pim;

import com.solvd.mapper.EmployeeMapper;
import com.solvd.model.Employee;
import com.solvd.pages.common.pim.PimPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public abstract class PimPageMobile extends PimPageBase {

    public PimPageMobile(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[contains(@class,  'oxd-table-filter-header')]//button")
    private ExtendedWebElement openSearchButton;

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

    @Override
    public void clickSearchEmployeeButton() {
        searchEmployeeButton.scrollTo();
        searchEmployeeButton.click();
    }

    @Override
    public void inputIdEmployee(String id) {
        clickOpenSearchButton();
        super.inputIdEmployee(id);
    }

    @Override
    public Employee mapToEmployee(WebElement webElement) {
        return EmployeeMapper.mapToEmployeeFromWebElementMobile(webElement);
    }

    @Override
    public List<Employee> mapToEmployeeList(List<ExtendedWebElement> employees) {
        return EmployeeMapper.mapListToEmployeesMobile(employeeList);
    }

    protected void clickOpenSearchButton() {
        openSearchButton.scrollTo();
        openSearchButton.click();
    }
}

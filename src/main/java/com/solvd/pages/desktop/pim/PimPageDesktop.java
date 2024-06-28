package com.solvd.pages.desktop.pim;

import com.solvd.mapper.EmployeeMapper;
import com.solvd.model.Employee;
import com.solvd.pages.common.pim.PimPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


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
    public void getMenuByClick() {
        throw new NotImplementedException("Not implemented for desktop");
    }

    @Override
    public void clickSearchEmployeeButton() {
        searchEmployeeButton.click();
    }

    @Override
    public void inputIdEmployee(String id) {
        idEmployeeField.click();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value='';", idEmployeeField.getElement());
        idEmployeeField.type(id);
    }

    @Override
    public Employee mapToEmployee(WebElement webElement) {
        return EmployeeMapper.mapToEmployeeFromWebElementDesktop(webElement);
    }

    @Override
    public List<Employee> mapToEmployeeList(List<ExtendedWebElement> employees) {
        return EmployeeMapper.mapListToEmployeesDesktop(employeeList);
    }
}

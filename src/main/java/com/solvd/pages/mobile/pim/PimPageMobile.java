package com.solvd.pages.mobile.pim;

import com.solvd.mapper.EmployeeMapper;
import com.solvd.model.Employee;
import com.solvd.pages.common.pim.PimPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PimPageBase.class)
public class PimPageMobile extends PimPageBase {

    @FindBy(xpath = "//div[@class = 'oxd-table-filter-header-options']//button")
    private ExtendedWebElement infoButton;

    @FindBy(xpath = "//div[@class = 'oxd-table-filter-header']//button")
    private ExtendedWebElement openSearchButton;


    public PimPageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSearchEmployeeButton() {
        searchEmployeeButton.scrollTo();
        searchEmployeeButton.click();
    }

    @Override
    public void inputIdEmployee(String id) {
        clickOpenSearchButton();
        idEmployeeField.click();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value='';", idEmployeeField.getElement());
        idEmployeeField.type(id);
    }

    @Override
    public Employee mapToEmployee(WebElement webElement) {
        return EmployeeMapper.mapToEmployeeFromWebElementMobile(webElement);
    }

    @Override
    public List<Employee> mapToEmployeeList(List<ExtendedWebElement> employees) {
        return EmployeeMapper.mapListToEmployeesMobile(employees);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }

    private void clickOpenSearchButton() {
        openSearchButton.scrollTo();
        openSearchButton.click();
    }
}

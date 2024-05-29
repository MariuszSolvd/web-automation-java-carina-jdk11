package com.solvd.pages.desktop.pim;

import com.solvd.model.Employee;
import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.solvd.pages.common.pim.EmployeePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AddEmployeePageBase.class)
public class AddEmployeePage extends AddEmployeePageBase {

    @FindBy(name = "firstName")
    private ExtendedWebElement fistNameField;
    @FindBy(name = "middleName")
    private ExtendedWebElement middleNameField;
    @FindBy(name = "lastName")
    private ExtendedWebElement lastNameField;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private ExtendedWebElement idEmployeeField;
    @FindBy(xpath = "//button[@type = 'submit']")
    private ExtendedWebElement saveButton;

    public AddEmployeePage(WebDriver webDriver) {
        super(webDriver);
        setUiLoadedMarker(idEmployeeField);
    }

    @Override
    public void inputFirstName(String firstName) {
        fistNameField.type(firstName);
    }

    @Override
    public void inputMiddleName(String middleName) {
        middleNameField.type(middleName);
    }

    @Override
    public void inputLastName(String lastName) {
        lastNameField.type(lastName);
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
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    public EmployeePageBase addEmployee(Employee employee) {
        inputFirstName(employee.getFirstName());
        inputMiddleName(employee.getMiddleName());
        inputLastName(employee.getLastName());
        inputIdEmployee(employee.getIdEmployee());
        clickSaveButton();
        //TODO: Check during test if wait for it is enough in Carina
        return initPage(getDriver(), EmployeePageBase.class);
    }

}

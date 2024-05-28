package com.solvd.pages.pim;

import com.solvd.model.Employee;
import com.solvd.pages.AbstractPageWithLeftMenu;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends AbstractPageWithLeftMenu {

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

    public void inputFirstName(String firstName) {
        fistNameField.type(firstName);
    }

    public void inputMiddleName(String middleName) {
        middleNameField.type(middleName);
    }

    public void inputLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void inputIdEmployee(String id) {
        idEmployeeField.click();
        //Is it only one way,  that works in Carina since method clear() is not implemented??
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value='';", idEmployeeField.getElement());
        idEmployeeField.type(id);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public EmployeePage addEmployee(Employee employee) {
        inputFirstName(employee.getFirstName());
        inputMiddleName(employee.getMiddleName());
        inputLastName(employee.getLastName());
        inputIdEmployee(employee.getIdEmployee());
        clickSaveButton();
        //TODO: Check during test if wait for it is enough in Carina
        return new EmployeePage(getDriver());
    }

}

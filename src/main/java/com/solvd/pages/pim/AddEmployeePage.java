package com.solvd.pages.pim;

import com.solvd.model.Employee;
import com.solvd.pages.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddEmployeePage extends AbstractMenuPage {

    @FindBy(name = "firstName")
    private WebElement fistNameField;
    @FindBy(name = "middleName")
    private WebElement middleNameField;
    @FindBy(name = "lastName")
    private WebElement lastNameField;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private WebElement idEmployeeField;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement saveButton;

    public AddEmployeePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputFirstName(String firstName) {
        sendKeysWrapper(fistNameField, firstName);
    }

    public void inputMiddleName(String middleName) {
        sendKeysWrapper(middleNameField, middleName);
    }

    public void inputLastName(String lastName) {
        sendKeysWrapper(lastNameField, lastName);
    }

    public void inputIdEmployee(String id) {
        cleanTextboxWrapper(idEmployeeField);
        sendKeysWrapper(idEmployeeField, id);
    }

    public void clickSaveButton() {
        clickWrapper(saveButton);
    }

    public EmployeePage addEmployee(Employee employee) {
        inputFirstName(employee.getFirstName());
        inputMiddleName(employee.getMiddleName());
        inputLastName(employee.getLastName());
        inputIdEmployee(employee.getIdEmployee());
        clickSaveButton();
        EmployeePage employeePage = new EmployeePage(webDriver);
        employeePage.waitToPageToLoad();
        return employeePage;
    }

}

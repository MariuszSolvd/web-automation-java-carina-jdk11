package com.solvd.pages.pim;

import com.solvd.model.Employee;
import com.solvd.pages.AbstractPageWithLeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
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
        //TODO :Check out if clean work with sendKeys or has to use type method
        idEmployeeField.click();
        idEmployeeField.sendKeys(Keys.CONTROL + "a");
        idEmployeeField.sendKeys(Keys.BACK_SPACE);
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

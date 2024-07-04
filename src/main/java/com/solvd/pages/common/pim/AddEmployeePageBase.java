package com.solvd.pages.common.pim;

import com.solvd.model.Employee;
import com.solvd.pages.common.PageWithLeftMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AddEmployeePageBase extends PageWithLeftMenuBase {
    @FindBy(name = "firstName")
    private ExtendedWebElement fistNameField;

    @FindBy(name = "middleName")
    private ExtendedWebElement middleNameField;

    @FindBy(name = "lastName")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    protected ExtendedWebElement idEmployeeField;

    @FindBy(xpath = "//button[@type = 'submit']")
    protected ExtendedWebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'employee-image-wrapper')]")
    private ExtendedWebElement employeeImage;

    public AddEmployeePageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(employeeImage);
    }

    protected void inputFirstName(String firstName) {
        fistNameField.type(firstName);
    }

    protected void inputMiddleName(String middleName) {
        middleNameField.type(middleName);
    }

    protected void inputLastName(String lastName) {
        lastNameField.type(lastName);
    }

    protected abstract void inputIdEmployee(String id);

    public abstract void clickSaveButton();

    public EmployeePageBase addEmployee(Employee employee) {
        inputFirstName(employee.getFirstName());
        inputMiddleName(employee.getMiddleName());
        inputLastName(employee.getLastName());
        inputIdEmployee(employee.getIdEmployee());
        clickSaveButton();
        return initPage(getDriver(), EmployeePageBase.class);
    }
}

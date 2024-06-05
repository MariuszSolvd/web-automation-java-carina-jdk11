package com.solvd.pages.common.pim;

import com.solvd.model.Employee;
import com.solvd.pages.common.AbstractPageWithLeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AddEmployeePageBase extends AbstractPageWithLeftMenu {
    @FindBy(name = "firstName")
    private ExtendedWebElement fistNameField;
    @FindBy(name = "middleName")
    private ExtendedWebElement middleNameField;
    @FindBy(name = "lastName")
    private ExtendedWebElement lastNameField;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private ExtendedWebElement idEmployeeField;
    @FindBy(xpath = "//button[@type = 'submit']")
    protected ExtendedWebElement saveButton;

    public AddEmployeePageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(idEmployeeField);
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

    protected void inputIdEmployee(String id) {
        idEmployeeField.click();
        //Is it only one way,  that works in Carina since method clear() is not implemented??
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value='';", idEmployeeField.getElement());
        idEmployeeField.type(id);
    }

    public abstract void clickSaveButton();

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

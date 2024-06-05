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
public class AddEmployeePageDesktop extends AddEmployeePageBase {

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

    public AddEmployeePageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
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

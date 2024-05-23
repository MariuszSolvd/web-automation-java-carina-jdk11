package com.solvd.pages.pim;

import com.solvd.pages.LeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EmployeePage extends AbstractPage {

    @FindBy(name = "firstName")
    private ExtendedWebElement firstNameField;
    @FindBy(name = "middleName")
    private ExtendedWebElement middleNameField;
    @FindBy(name = "lastName")
    private ExtendedWebElement lastNameField;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private ExtendedWebElement idEmployeeField;
    @FindBy(xpath = "//div[contains(@class, 'employee-navigation')]")
    private ExtendedWebElement employeeNav;
    @Getter
    private LeftMenu leftMenu;

    public EmployeePage(WebDriver webDriver) {
        super(webDriver);
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public String getFirstNameText() {
        return getValueWrapper(firstNameField);
    }

    public String getMiddleNameText() {
        return getValueWrapper(middleNameField);
    }

    public String getLastNameText() {
        return getValueWrapper(lastNameField);
    }

    public String getIdEmployeeText() {
        return getValueWrapper(idEmployeeField);
    }

    private String getValueWrapper(ExtendedWebElement element) {
        //TODO: Check if it waits for value attribute during test
        return element.getAttribute("value");
    }
}

package com.solvd.pages.common.pim;

import com.solvd.pages.common.AbstractPageWithLeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class EmployeePageBase extends AbstractPageWithLeftMenu {
    @FindBy(xpath = "//div[@class = 'orangehrm-edit-employee-content']//input[@name ='firstName']")
    protected ExtendedWebElement firstNameField;

    @FindBy(name = "middleName")
    protected ExtendedWebElement middleNameField;

    @FindBy(name = "lastName")
    protected ExtendedWebElement lastNameField;

    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    protected ExtendedWebElement idEmployeeField;

    @FindBy(xpath = "//div[contains(@class, 'employee-navigation')]")
    private ExtendedWebElement employeeNav;

    public EmployeePageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(firstNameField);
    }

    public abstract String getFirstNameText();

    public abstract String getMiddleNameText();

    public abstract String getLastNameText();

    public abstract String getIdEmployeeText();
}

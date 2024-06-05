package com.solvd.pages.common.pim;

import com.solvd.pages.common.AbstractPageWithLeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class EmployeePageBase extends AbstractPageWithLeftMenu {
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

    public EmployeePageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(idEmployeeField);
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
        return element.getAttribute("value");
    }

}

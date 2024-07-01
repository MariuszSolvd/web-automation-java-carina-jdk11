package com.solvd.pages.common.pim;

import com.solvd.pages.common.PageWithLeftMenuBase;
import com.solvd.utilities.Urls;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class EmployeePageBase extends PageWithLeftMenuBase {
    @FindBy(xpath = "//div[@class = 'orangehrm-edit-employee-content']//input[@name ='firstName']")
    protected ExtendedWebElement firstNameField;

    @FindBy(name = "middleName")
    protected ExtendedWebElement middleNameField;

    @FindBy(name = "lastName")
    protected ExtendedWebElement lastNameField;

    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    protected ExtendedWebElement idEmployeeField;

    public EmployeePageBase(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Urls.EMPLOYEE_VIEW_PAGE_URL + "$ignore");
        setUiLoadedMarker(firstNameField);
    }

    public abstract String getFirstNameText();

    public abstract String getMiddleNameText();

    public abstract String getLastNameText();

    public abstract String getIdEmployeeText();

    public void waitForDataToLoad() {
        waitUntil((ExpectedCondition<Boolean>) input -> !getFirstNameText().isBlank() && !getIdEmployeeText().isBlank(), 30);
    }
}

package com.solvd.pages.pim;

import com.solvd.pages.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class EmployeePage extends AbstractMenuPage {

    @FindBy(name = "firstName")
    private WebElement firstNameField;
    @FindBy(name = "middleName")
    private WebElement middleNameField;
    @FindBy(name = "lastName")
    private WebElement lastNameField;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private WebElement idEmployeeField;
    @FindBy(xpath = "//div[contains(@class, 'employee-navigation')]")
    private WebElement employeeNav;

    public EmployeePage(WebDriver webDriver) {
        super(webDriver);
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

    public void waitToPageToLoad() {
        webDriverWait.until(ExpectedConditions.visibilityOf(employeeNav));
        webDriverWait.until(ExpectedConditions.visibilityOf(firstNameField));
        webDriverWait.until(ExpectedConditions.visibilityOf(middleNameField));
        webDriverWait.until(ExpectedConditions.visibilityOf(lastNameField));
        webDriverWait.until(ExpectedConditions.visibilityOf(idEmployeeField));
    }

    public boolean isOpen() {
        for (WebElement element : getAllElements()) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    private List<WebElement> getAllElements() {
        return List.of(employeeNav, firstNameField, middleNameField, lastNameField, idEmployeeField);
    }
}

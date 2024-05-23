package com.solvd.pages.pim;

import com.solvd.pages.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PimPage extends AbstractMenuPage {

    @FindBy(xpath = "//button[contains(., 'Add')]")
    private WebElement addEmployeeButton;
    @FindBy(xpath = "//button[contains(., 'Search')]")
    private WebElement searchEmployeeButton;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private WebElement idEmployeeField;
    @FindBy(xpath = "//button[contains(@class, 'label-danger')]")
    private WebElement deleteConfirmationButton;
    @FindBy(xpath = "//div[@class ='oxd-table-card']/*")
    private List<WebElement> employeeList;

    public PimPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddEmployeePage clickAddEmployeeButton() {
        clickWrapper(addEmployeeButton);
        return new AddEmployeePage(webDriver);
    }

    public void clickSearchEmployeeButton() {
        clickWrapper(searchEmployeeButton);
    }

    public void inputIdEmployee(String id) {
        cleanTextboxWrapper(idEmployeeField);
        sendKeysWrapper(idEmployeeField, id);
    }

    public List<WebElement> getEmployeeList() {
        loadWebElementList(employeeList);
        return employeeList;
    }

    public void clickDeleteConfirmationButton() {
        clickWrapper(deleteConfirmationButton);
    }
}

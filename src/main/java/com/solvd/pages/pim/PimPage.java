package com.solvd.pages.pim;

import com.solvd.pages.LeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PimPage extends AbstractPage {

    @FindBy(xpath = "//button[contains(., 'Add')]")
    private ExtendedWebElement addEmployeeButton;
    @FindBy(xpath = "//button[contains(., 'Search')]")
    private ExtendedWebElement searchEmployeeButton;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private ExtendedWebElement idEmployeeField;
    @FindBy(xpath = "//button[contains(@class, 'label-danger')]")
    private ExtendedWebElement deleteConfirmationButton;
    @FindBy(xpath = "//div[@class ='oxd-table-card']/*")
    private List<ExtendedWebElement> employeeList;
    @Getter
    private LeftMenu leftMenu;

    public PimPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddEmployeePage clickAddEmployeeButton() {
        addEmployeeButton.click();
        return new AddEmployeePage(getDriver());
    }

    public void clickSearchEmployeeButton() {
        searchEmployeeButton.click();
    }

    public void inputIdEmployee(String id) {
        //TODO :Check out if clean work with sendKeys or has to use type method
        idEmployeeField.click();
        idEmployeeField.sendKeys(Keys.CONTROL + "a");
        idEmployeeField.sendKeys(Keys.BACK_SPACE);
        idEmployeeField.type(id);
    }

    public List<ExtendedWebElement> getEmployeeList() {
        return employeeList;
    }

    public void clickDeleteConfirmationButton() {
        deleteConfirmationButton.click();
    }
}

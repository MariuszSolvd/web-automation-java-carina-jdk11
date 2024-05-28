package com.solvd.pages.pim;

import com.solvd.pages.AbstractPageWithLeftMenu;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PimPage extends AbstractPageWithLeftMenu {

    @FindBy(xpath = "//button[contains(., 'Add')]")
    private ExtendedWebElement addEmployeeButton;
    @FindBy(xpath = "//button[contains(., 'Search')]")
    private ExtendedWebElement searchEmployeeButton;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private ExtendedWebElement idEmployeeField;
    @FindBy(xpath = "//button[contains(@class, 'label-danger')]")
    private ExtendedWebElement deleteConfirmationButton;
    @Getter
    @FindBy(xpath = "//div[@class ='oxd-table-card']/*")
    private List<ExtendedWebElement> employeeList;
    @FindBy(xpath = "//div[@class = 'orangehrm-container']")
    private ExtendedWebElement employeeContainer;

    public PimPage(WebDriver webDriver) {
        super(webDriver);
        setUiLoadedMarker(employeeContainer);
    }

    public AddEmployeePage clickAddEmployeeButton() {
        addEmployeeButton.click();
        return new AddEmployeePage(getDriver());
    }

    public void clickSearchEmployeeButton() {
        searchEmployeeButton.click();
    }

    public void inputIdEmployee(String id) {
        idEmployeeField.click();
        //Is it only one way,  that works in Carina since method clear() is not implemented??
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value='';", idEmployeeField.getElement());
        idEmployeeField.type(id);
    }

    public void clickDeleteConfirmationButton() {
        deleteConfirmationButton.click();
    }
}

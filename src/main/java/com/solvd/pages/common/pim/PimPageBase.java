package com.solvd.pages.common.pim;

import com.solvd.model.Employee;
import com.solvd.pages.common.PageWithLeftMenuBase;
import com.solvd.utilities.Urls;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class PimPageBase extends PageWithLeftMenuBase {

    @Getter
    @FindBy(xpath = "//div[@role = 'rowgroup']/div[contains(@class, 'oxd-table-card')]/*")
    protected List<ExtendedWebElement> employeeList;

    @FindBy(xpath = "//button[contains(., 'Add')]")
    private ExtendedWebElement addEmployeeButton;

    @FindBy(xpath = "//button[contains(., 'Search')]")
    protected ExtendedWebElement searchEmployeeButton;

    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    protected ExtendedWebElement idEmployeeField;

    @FindBy(xpath = "//button[contains(@class, 'label-danger')]")
    protected ExtendedWebElement deleteConfirmationButton;

    @FindBy(xpath = "//div[contains(@class, 'oxd-table-body')]")
    protected ExtendedWebElement rowGroupElement;

    public PimPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setPageAbsoluteURL(Urls.EMPLOYEES_VIEW_PAGE_URL);
        setUiLoadedMarker(rowGroupElement);
    }

    public AddEmployeePageBase clickAddEmployeeButton() {
        addEmployeeButton.click();
        return initPage(getDriver(), AddEmployeePageBase.class);
    }

    public abstract void clickSearchEmployeeButton();

    public abstract void inputIdEmployee(String id);

    public void clickDeleteConfirmationButton() {
        deleteConfirmationButton.click();
    }

    public abstract Employee mapToEmployee(WebElement webElement);

    public abstract List<Employee> mapToEmployeeList(List<ExtendedWebElement> employees);
}

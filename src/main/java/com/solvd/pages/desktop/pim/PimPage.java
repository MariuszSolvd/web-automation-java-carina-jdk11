package com.solvd.pages.desktop.pim;

import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.solvd.pages.common.pim.PimPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PimPageBase.class)
public class PimPage extends PimPageBase {

    @FindBy(xpath = "//button[contains(., 'Add')]")
    private ExtendedWebElement addEmployeeButton;
    @FindBy(xpath = "//button[contains(., 'Search')]")
    private ExtendedWebElement searchEmployeeButton;
    @FindBy(xpath = "//div[label[contains(text(), \"Employee Id\")]]/following-sibling::*/input")
    private ExtendedWebElement idEmployeeField;
    @FindBy(xpath = "//button[contains(@class, 'label-danger')]")
    private ExtendedWebElement deleteConfirmationButton;
    @FindBy(xpath = "//div[@class = 'orangehrm-container']")
    private ExtendedWebElement employeeContainer;

    public PimPage(WebDriver webDriver) {
        super(webDriver);
        setUiLoadedMarker(employeeContainer);
    }

    @Override
    public AddEmployeePageBase clickAddEmployeeButton() {
        addEmployeeButton.click();
        return initPage(getDriver(), AddEmployeePageBase.class);
    }

    @Override
    public void clickSearchEmployeeButton() {
        searchEmployeeButton.click();
    }

    @Override
    public void inputIdEmployee(String id) {
        idEmployeeField.click();
        //Is it only one way,  that works in Carina since method clear() is not implemented??
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value='';", idEmployeeField.getElement());
        idEmployeeField.type(id);
    }

    @Override
    public void clickDeleteConfirmationButton() {
        deleteConfirmationButton.click();
    }
}

package com.solvd.pages.desktop.pim;

import com.solvd.pages.common.pim.EmployeePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = EmployeePageBase.class)
public class EmployeePage extends EmployeePageBase {

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

    public EmployeePage(WebDriver webDriver) {
        super(webDriver);
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

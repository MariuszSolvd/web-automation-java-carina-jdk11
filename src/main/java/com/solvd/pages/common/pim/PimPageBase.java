package com.solvd.pages.common.pim;

import com.solvd.pages.desktop.AbstractPageWithLeftMenu;
import com.solvd.pages.desktop.pim.AddEmployeePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class PimPageBase extends AbstractPageWithLeftMenu {

    @Getter
    @FindBy(xpath = "//div[@class ='oxd-table-card']/*")
    protected List<ExtendedWebElement> employeeList;

    public PimPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AddEmployeePageBase clickAddEmployeeButton();

    public abstract void clickSearchEmployeeButton();

    public abstract void inputIdEmployee(String id);

    public abstract void clickDeleteConfirmationButton();
}

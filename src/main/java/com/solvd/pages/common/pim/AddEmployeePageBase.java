package com.solvd.pages.common.pim;

import com.solvd.model.Employee;
import com.solvd.pages.desktop.AbstractPageWithLeftMenu;
import org.openqa.selenium.WebDriver;

public abstract class AddEmployeePageBase extends AbstractPageWithLeftMenu {

    public AddEmployeePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void inputFirstName(String firstName);

    public abstract void inputMiddleName(String middleName);

    public abstract void inputLastName(String lastName);

    public abstract void inputIdEmployee(String id);

    public abstract void clickSaveButton();

    public abstract EmployeePageBase addEmployee(Employee employee);
}

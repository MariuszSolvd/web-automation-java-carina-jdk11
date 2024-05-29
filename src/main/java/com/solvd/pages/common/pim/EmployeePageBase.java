package com.solvd.pages.common.pim;

import com.solvd.pages.desktop.AbstractPageWithLeftMenu;
import org.openqa.selenium.WebDriver;

public abstract class EmployeePageBase extends AbstractPageWithLeftMenu {

    public EmployeePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getFirstNameText();

    public abstract String getMiddleNameText();

    public abstract String getLastNameText();

    public abstract String getIdEmployeeText();

}

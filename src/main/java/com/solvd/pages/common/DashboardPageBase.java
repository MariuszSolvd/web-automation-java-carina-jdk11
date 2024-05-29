package com.solvd.pages.common;

import com.solvd.pages.desktop.AbstractPageWithLeftMenu;
import org.openqa.selenium.WebDriver;

public abstract class DashboardPageBase extends AbstractPageWithLeftMenu {

    public DashboardPageBase(WebDriver driver) {
        super(driver);
    }
}

package com.solvd.pages;


import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends AbstractPageWithLeftMenu {

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
        setPageURL(R.CONFIG.get("dashboard.url"));
        open();
    }

}

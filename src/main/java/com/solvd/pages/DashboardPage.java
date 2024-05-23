package com.solvd.pages;


import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends AbstractPage {

    @Getter
    private LeftMenu leftMenu;

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

}

package com.solvd.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public class AbstractPageWithLeftMenu extends AbstractPage {

    protected LeftMenu leftMenu;

    public AbstractPageWithLeftMenu(WebDriver driver) {
        super(driver);
    }
}

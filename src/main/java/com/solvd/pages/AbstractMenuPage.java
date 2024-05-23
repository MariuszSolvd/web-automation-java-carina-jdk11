package com.solvd.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractMenuPage extends AbstractPage {

    protected LeftMenu leftMenu;

    public AbstractMenuPage(WebDriver webDriver) {
        super(webDriver);
        this.leftMenu = new LeftMenu(webDriver);
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }

}

package com.solvd.pages.desktop;

import com.solvd.pages.desktop.components.LeftMenu;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public abstract class AbstractPageWithLeftMenu extends AbstractPage {
    @FindBy(xpath = "//nav[@class= 'oxd-navbar-nav']")
    protected LeftMenu leftMenu;

    public AbstractPageWithLeftMenu(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }
}

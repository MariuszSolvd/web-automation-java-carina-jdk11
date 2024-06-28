package com.solvd.pages.common;

import com.solvd.pages.common.components.LeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public abstract class PageWithLeftMenuBase extends AbstractPage {
    @FindBy(xpath = "//nav[@class= 'oxd-navbar-nav']")
    protected LeftMenu leftMenu;

    @FindBy(xpath = "//i[contains(@class, 'hamburger')]")
    protected ExtendedWebElement menuButton;

    public PageWithLeftMenuBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(leftMenu);
    }

    public abstract void clickMenuButtonByHref(String href);

    public abstract void getMenuByClick();
}

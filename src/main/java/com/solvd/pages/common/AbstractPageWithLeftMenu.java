package com.solvd.pages.common;

import com.solvd.pages.common.components.LeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public abstract class AbstractPageWithLeftMenu extends AbstractPage {
    @FindBy(xpath = "//nav[@class= 'oxd-navbar-nav']")
    protected LeftMenu leftMenu;
    @FindBy(xpath = "//i[contains(@class, 'hamburger')]")
    protected ExtendedWebElement menuButton;

    public AbstractPageWithLeftMenu(WebDriver driver) {
        super(driver);
    }

    public abstract void clickMenuButtonByHref(String href);

    public void getMenuByClick() {
        menuButton.click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(leftMenu.getBy()), 30);
    }
}

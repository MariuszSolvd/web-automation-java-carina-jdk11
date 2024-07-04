package com.solvd.pages.common;

import com.solvd.pages.common.components.LeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public abstract class PageWithLeftMenuBase extends AbstractPage {

    @FindBy(xpath = "//nav[@class='oxd-navbar-nav']")
    protected LeftMenu leftMenu;

    @FindBy(xpath = "//i[contains(@class, 'hamburger')]")
    protected ExtendedWebElement menuButton;

    @FindBy(xpath = "//i[contains(@class, 'oxd-userdropdown-icon')]")
    private ExtendedWebElement userButton;

    @FindBy(xpath = "//a[contains(@href, '/web/index.php/auth/logout')]")
    private ExtendedWebElement logoutButton;

    public PageWithLeftMenuBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(leftMenu);
    }

    public abstract void clickMenuButtonByHref(String href);

    public abstract void getMenuByClick();

    public LoginPageBase logout() {
        userButton.click();
        logoutButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
}

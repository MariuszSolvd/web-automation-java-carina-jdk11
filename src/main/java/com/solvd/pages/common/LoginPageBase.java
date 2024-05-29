package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void inputUsername(String username);

    public abstract void inputPassword(String password);

    public abstract void clickLoginButton();

    public abstract boolean isAlertDisplayed();

    public abstract void logIn(String username, String password);
}

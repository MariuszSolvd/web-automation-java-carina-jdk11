package com.solvd.pages;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(name = "username")
    private ExtendedWebElement usernameField;
    @FindBy(name = "password")
    private ExtendedWebElement passwordField;
    @FindBy(xpath = "//button")
    private ExtendedWebElement loginButton;
    @FindBy(xpath = "//div[@role = 'alert']")
    private ExtendedWebElement alertField;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        setPageURL(R.CONFIG.get("login.url"));
    }

    public void inputUsername(String username) {
        usernameField.type(username);
    }

    public void inputPassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isAlertDisplayed() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(alertField.getBy()), 30);
        return alertField.isDisplayed();
    }

    public void logIn(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }
}


package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(name = "username")
    private WebElement usernameField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//button")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@role = 'alert']")
    private WebElement alertField;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputUsername(String username) {
        sendKeysWrapper(usernameField, username);
    }

    public void inputPassword(String password) {
        sendKeysWrapper(passwordField, password);
    }

    public void clickLoginButton() {
        clickWrapper(loginButton);
    }

    public boolean isAlertVisible() {
        webDriverWait.until(ExpectedConditions.visibilityOf(alertField));
        return alertField.isDisplayed();
    }

    public void logIn(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }
}


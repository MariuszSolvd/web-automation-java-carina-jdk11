package com.solvd.pages;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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
        open();
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

    public boolean isAlertVisible() {
        return alertField.isDisplayed();
    }

    public DashboardPage logIn(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
        return new DashboardPage(getDriver());
    }
}


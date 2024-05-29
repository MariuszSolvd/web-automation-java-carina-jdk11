package com.solvd.pages.desktop;


import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

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
        setUiLoadedMarker(usernameField);
    }

    @Override
    public void inputUsername(String username) {
        usernameField.type(username);
    }

    @Override
    public void inputPassword(String password) {
        passwordField.type(password);
    }

    @Override
    public void clickLoginButton() {
        loginButton.click();
    }

    @Override
    public boolean isAlertDisplayed() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(alertField.getBy()), 30);
        return alertField.isDisplayed();
    }

    @Override
    public void logIn(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }
}


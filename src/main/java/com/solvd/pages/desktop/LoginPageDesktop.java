package com.solvd.pages.desktop;


import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPageDesktop extends LoginPageBase {

    public LoginPageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void logIn(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }
}


package com.solvd.pages.ios;

import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.ios.IOSUtils;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPageIOs extends LoginPageBase implements IOSUtils {

    public LoginPageIOs(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void logIn(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }
}

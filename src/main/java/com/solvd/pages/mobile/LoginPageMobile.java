package com.solvd.pages.mobile;

import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPageMobile extends LoginPageBase implements IAndroidUtils {

    public LoginPageMobile(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void logIn(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        pressBack();
        clickLoginButton();
    }
}

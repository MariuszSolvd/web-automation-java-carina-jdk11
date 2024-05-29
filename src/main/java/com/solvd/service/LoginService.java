package com.solvd.service;

import com.solvd.pages.common.DashboardPageBase;
import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.WebDriver;

public class LoginService implements ICustomTypePageFactory {


    public DashboardPageBase successfulLogin() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));

        return initPage(getDriver(), DashboardPageBase.class);
    }
}

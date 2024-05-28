package com.solvd.service;

import com.solvd.pages.DashboardPage;
import com.solvd.pages.LoginPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;

public class LoginService {


    public static DashboardPage successfulLogin(WebDriver webDriver) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));

        return new DashboardPage(webDriver);
    }
}

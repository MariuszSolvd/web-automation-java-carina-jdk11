package com.solvd.service;

import com.solvd.pages.DashboardPage;
import com.solvd.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static com.solvd.utilities.Urls.LOGIN_PAGE_URL;

public class LoginService {

    private final LoginPage loginPage;
    private final WebDriver webDriver;
    private final String USERNAME = "Admin";
    private final String PASSWORD = "admin123";

    public LoginService(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(LOGIN_PAGE_URL);
        this.loginPage = new LoginPage(webDriver);
    }

    public DashboardPage successfulLogin() {
        loginPage.logIn(USERNAME, PASSWORD);
        return new DashboardPage(webDriver);
    }
}

package com.slovd;

import com.solvd.pages.DashboardPage;
import com.solvd.service.LoginService;
import com.solvd.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static com.solvd.utilities.Urls.*;
import static org.testng.Assert.*;

public abstract class AbstractTest {
    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        webDriver.set(DriverFactory.getDriver(browser));
        webDriver.get().manage().window().maximize();
    }

    protected void assertSuccessfulLogin(String url) {
        assertEquals(url, DASHBOARD_PAGE_URL,
                "Log in was unsuccessful");
    }

    protected DashboardPage login() {
        LoginService loginService = new LoginService(webDriver.get());
        return loginService.successfulLogin();
    }

    @AfterMethod
    public void closeDown() {
        webDriver.get().quit();
        webDriver.remove();

    }
}

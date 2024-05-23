package com.solvd.utilities;

import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.solvd.utilities.PropertiesUtil.get;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        WebDriver webDriver;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            String seleniumHubUrl = R.CONFIG.get("selenium.url");
            webDriver = new RemoteWebDriver(new URI(seleniumHubUrl).toURL(), capabilities);
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException("Could not connect to Selenium Grid Hub");
        }
        return webDriver;
    }
}

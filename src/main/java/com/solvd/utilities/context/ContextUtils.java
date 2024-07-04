package com.solvd.utilities.context;

import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.Decorated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Set;

public class ContextUtils implements IDriverPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public WebDriver getPureDriver(WebDriver driver) {
        if (driver instanceof Decorated<?>) {
            driver = (WebDriver) ((Decorated<?>) driver).getOriginal();
        }
        return driver;
    }

    public void switchMobileContext(String context){
        switchMobileContext(context, null);
    }

    public String getCurrentContext() {
        DriverHelper help = new DriverHelper();
        WebDriver driver = getDriver();
        return help.performIgnoreException(((ContextAware) driver)::getContext);
    }

    public void switchMobileContext(String context, String exclude) {
        WebDriver driver = getDriver();
        DriverHelper help = new DriverHelper();
        Set<String> contextHandles = help.performIgnoreException(((ContextAware) driver)::getContextHandles);
        String desiredContext = "";
        boolean isContextPresent = false;
        LOGGER.info("Existing contexts: ");
        for (String cont : contextHandles) {
            if (cont.contains(context)) {
                if (exclude != null && cont.contains(exclude)) {
                    continue;
                }
                desiredContext = cont;
                isContextPresent = true;
            }
            LOGGER.info(cont);
        }
        if (!isContextPresent) {
            throw new NotFoundException("Desired context is not present");
        }
        LOGGER.info("Switching to context : " + desiredContext);
        ((SupportsContextSwitching) driver).context(desiredContext);
    }
}

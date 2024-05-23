package com.solvd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(AbstractPage.class);
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(120));
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void waitForUrl(String url) {
        webDriverWait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return driver.getCurrentUrl().equals(url);
        });
    }

    protected void sendKeysWrapper(WebElement webElement, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(keys);
        log.info("{} was passed to {}", keys, webElement);
    }

    protected void clickWrapper(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        log.info("{} was clicked", webElement);
    }

    protected String getValueWrapper(WebElement webElement) {
        webDriverWait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return webElement.isDisplayed() && !webElement.getAttribute("value").isEmpty();
        });
        return webElement.getAttribute("value");
    }

    protected void loadWebElementList(List<WebElement> webElementList) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
    }

    protected void cleanTextboxWrapper(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.BACK_SPACE);
        log.info("Textbox of {} was cleared", webElement);
    }
}

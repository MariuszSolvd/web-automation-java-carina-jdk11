package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMenu extends AbstractPage {

    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']//a")
    private List<WebElement> menuButtons;

    public LeftMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getButtonByHref(String href) {
        loadWebElementList(menuButtons);
        return menuButtons.stream()
                .filter(button -> button.getAttribute("href").equals(href))
                .findFirst()
                .get();
    }

}

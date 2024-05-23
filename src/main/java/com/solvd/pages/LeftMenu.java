package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMenu extends AbstractUIObject {

    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']//a")
    private List<ExtendedWebElement> menuButtons;

    public LeftMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public ExtendedWebElement getButtonByHref(String href) {
        return menuButtons.stream()
                .filter(button -> button.getAttribute("href").equals(href))
                .findFirst()
                .get();
    }

}

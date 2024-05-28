package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LeftMenu extends AbstractUIObject {

    @FindBy(xpath = ".//li[@class='oxd-main-menu-item-wrapper']//a")
    private List<ExtendedWebElement> menuButtons;

    public LeftMenu(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
    }

    public ExtendedWebElement getButtonByHref(String href) {
        return menuButtons.stream()
                .filter(button -> button.getAttribute("href").equals(href))
                .findFirst()
                .get();
    }

    public List<ExtendedWebElement> getMenuButtons() {
        return menuButtons;
    }

}

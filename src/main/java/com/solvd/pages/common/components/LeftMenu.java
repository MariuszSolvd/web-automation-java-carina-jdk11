package com.solvd.pages.common.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class LeftMenu extends AbstractUIObject {

    @FindBy(xpath = ".//li[@class='oxd-main-menu-item-wrapper']//a")
    private List<ExtendedWebElement> menuButtons;

    public LeftMenu(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
    }

    public ExtendedWebElement getButtonByHref(String href) {
        menuButtons = getMenuButtons();
        return menuButtons.stream()
                .filter(button -> button.getAttribute("href").equals(href))
                .findFirst()
                .get();
    }
}

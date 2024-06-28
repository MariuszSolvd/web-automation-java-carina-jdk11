package com.solvd.pages.mobile;

import com.solvd.pages.common.PageWithLeftMenuBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class PageWithLeftMenuBaseMobile extends PageWithLeftMenuBase {

    public PageWithLeftMenuBaseMobile(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(menuButton);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }

    @Override
    public void getMenuByClick() {
        menuButton.click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(leftMenu.getBy()), 30);
    }
}

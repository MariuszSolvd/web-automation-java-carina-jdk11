package com.solvd.pages.mobile.admin;

import com.solvd.pages.common.admin.AddJobPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public abstract class AddJobPageMobile extends AddJobPageBase {

    public AddJobPageMobile(WebDriver driver) {
        super(driver);
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

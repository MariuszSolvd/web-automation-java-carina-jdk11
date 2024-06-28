package com.solvd.pages.desktop;

import com.solvd.pages.common.PageWithLeftMenuBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import lombok.Getter;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;


@Getter
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PageWithLeftMenuBase.class)
public class PageWithLeftMenuDesktop extends PageWithLeftMenuBase {

    public PageWithLeftMenuDesktop(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }

    @Override
    public void getMenuByClick() {
        throw new NotImplementedException("Method not implemented");
    }
}

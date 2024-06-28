package com.solvd.pages.mobile.ios;


import com.solvd.pages.common.PageWithLeftMenuBase;
import com.solvd.pages.mobile.PageWithLeftMenuBaseMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PageWithLeftMenuBase.class)
public class PageWithLeftMenuIOs extends PageWithLeftMenuBaseMobile {
    public PageWithLeftMenuIOs(WebDriver driver) {
        super(driver);
    }


}

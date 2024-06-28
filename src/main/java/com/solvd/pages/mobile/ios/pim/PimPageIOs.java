package com.solvd.pages.mobile.ios.pim;

import com.solvd.pages.common.pim.PimPageBase;
import com.solvd.pages.mobile.pim.PimPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PimPageBase.class)
public class PimPageIOs extends PimPageMobile {

    public PimPageIOs(WebDriver driver) {
        super(driver);
    }

}

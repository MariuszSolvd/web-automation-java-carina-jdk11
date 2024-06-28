package com.solvd.pages.mobile.android.pim;

import com.solvd.pages.common.pim.PimPageBase;
import com.solvd.pages.mobile.pim.PimPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PimPageBase.class)
public class PimPageAndroid extends PimPageMobile {

    public PimPageAndroid(WebDriver driver) {
        super(driver);
    }

}

package com.solvd.pages.mobile.android.admin;

import com.solvd.pages.common.admin.JobListPageBase;
import com.solvd.pages.mobile.admin.JobListPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = JobListPageBase.class)
public class JobListPageAndroid extends JobListPageMobile {

    public JobListPageAndroid(WebDriver webDriver) {
        super(webDriver);
    }


}

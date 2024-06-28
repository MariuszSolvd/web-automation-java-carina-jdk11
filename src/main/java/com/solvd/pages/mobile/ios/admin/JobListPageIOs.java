package com.solvd.pages.mobile.ios.admin;

import com.solvd.pages.common.admin.JobListPageBase;
import com.solvd.pages.mobile.admin.JobListPageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = JobListPageBase.class)
public class JobListPageIOs extends JobListPageMobile {

    public JobListPageIOs(WebDriver webDriver) {
        super(webDriver);
    }

}

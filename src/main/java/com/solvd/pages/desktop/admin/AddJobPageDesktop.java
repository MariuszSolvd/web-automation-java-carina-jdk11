package com.solvd.pages.desktop.admin;

import com.solvd.pages.common.admin.AddJobPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AddJobPageBase.class)
public class AddJobPageDesktop extends AddJobPageBase {

    public AddJobPageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void getMenuByClick() {
        throw new NotImplementedException("Not implemented for desktop");
    }
}

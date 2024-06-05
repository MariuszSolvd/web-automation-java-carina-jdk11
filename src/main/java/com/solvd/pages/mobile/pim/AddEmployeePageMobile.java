package com.solvd.pages.mobile.pim;

import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddEmployeePageBase.class)
public class AddEmployeePageMobile extends AddEmployeePageBase implements IAndroidUtils {

    public AddEmployeePageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSaveButton() {
        swipe(saveButton);
        saveButton.click();
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }
}

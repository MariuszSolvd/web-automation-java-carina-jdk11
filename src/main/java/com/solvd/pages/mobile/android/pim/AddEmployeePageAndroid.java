package com.solvd.pages.mobile.android.pim;

import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.solvd.pages.mobile.pim.AddEmployeePageMobile;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddEmployeePageBase.class)
public class AddEmployeePageAndroid extends AddEmployeePageMobile implements IAndroidUtils {

    public AddEmployeePageAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSaveButton() {
        pressBack();
        swipe(saveButton);
        saveButton.click();
    }

    @Override
    protected void deleteId() {
        for (int i = 0; i < 4; i++) {
            pressKeyboardKey(AndroidKey.DEL);
        }
    }
}

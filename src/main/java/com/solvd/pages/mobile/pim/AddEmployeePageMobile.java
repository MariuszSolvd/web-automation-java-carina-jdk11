package com.solvd.pages.mobile.pim;

import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddEmployeePageBase.class)
public class AddEmployeePageMobile extends AddEmployeePageBase implements IAndroidUtils {

    public AddEmployeePageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void inputIdEmployee(String id) {
        waitUntil(ExpectedConditions.elementToBeClickable(idEmployeeField), 20);
        idEmployeeField.click();
        idEmployeeField.click();
        for (int i = 0; i < 4; i++) {
            pressKeyboardKey(AndroidKey.DEL);
        }
        idEmployeeField.type(id);
    }

    @Override
    public void clickSaveButton() {
        pressBack();
        swipe(saveButton);
        saveButton.click();
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }
}

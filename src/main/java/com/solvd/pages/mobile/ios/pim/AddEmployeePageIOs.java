package com.solvd.pages.mobile.ios.pim;

import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.solvd.pages.mobile.pim.AddEmployeePageMobile;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.ios.IOSUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddEmployeePageBase.class)
public class AddEmployeePageIOs extends AddEmployeePageMobile implements IOSUtils {

    public AddEmployeePageIOs(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSaveButton() {
        swipe(saveButton);
        saveButton.click();
    }

    @Override
    protected void deleteId() {
        for (int i = 0; i < 4; i++) {
            idEmployeeField.sendKeys(Keys.BACK_SPACE);
        }
    }
}

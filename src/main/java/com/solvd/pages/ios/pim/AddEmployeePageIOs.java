package com.solvd.pages.ios.pim;

import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.ios.IOSUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddEmployeePageBase.class)
public class AddEmployeePageIOs extends AddEmployeePageBase implements IOSUtils {

    public AddEmployeePageIOs(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void inputIdEmployee(String id) {
        waitUntil(ExpectedConditions.elementToBeClickable(idEmployeeField), 20);
        idEmployeeField.click();
        idEmployeeField.click();
        deleteId();
        idEmployeeField.type(id);
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

    private void deleteId() {
        for (int i = 0; i < 4; i++) {
            idEmployeeField.sendKeys(Keys.BACK_SPACE);
        }
    }
}

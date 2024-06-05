package com.solvd.pages.mobile.pim;

import com.solvd.pages.common.pim.PimPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PimPageBase.class)
public class PimPageMobile extends PimPageBase {
    @FindBy(xpath = "//div[@class = 'oxd-table-filter-header-options']//button")
    private ExtendedWebElement infoButton;

    public PimPageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSearchEmployeeButton() {

    }

    @Override
    public void inputIdEmployee(String id) {

    }

    @Override
    public void clickDeleteConfirmationButton() {

    }

    @Override
    public void clickMenuButtonByHref(String href) {

    }
}

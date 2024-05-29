package com.solvd.pages.desktop.admin;

import com.solvd.pages.common.admin.AdminPageBase;
import com.solvd.pages.common.admin.JobListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AdminPageBase.class)
public class AdminPage extends AdminPageBase {

    @FindBy(xpath = "//span[contains(text(), 'Job')]/parent::li")
    private ExtendedWebElement jobButton;
    @FindBy(xpath = "//a[contains(text(), 'Job Titles')]/parent::li")
    private ExtendedWebElement jobTitleButton;

    public AdminPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickJobButton() {
        jobButton.click();
    }

    @Override
    public void clickJobTitleButton() {
        jobTitleButton.click();
    }

    @Override
    public JobListPageBase getJobListPage() {
        clickJobButton();
        clickJobTitleButton();
        return initPage(getDriver(), JobListPageBase.class);
    }
}

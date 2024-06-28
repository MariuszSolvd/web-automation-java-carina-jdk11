package com.solvd.pages.common.admin;

import com.solvd.utilities.Urls;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AdminPageBase extends AbstractAdminPage {
    @FindBy(xpath = "//span[contains(text(), 'Job')]/parent::li")
    private ExtendedWebElement jobButton;

    @FindBy(xpath = "//a[contains(text(), 'Job Titles')]/parent::li")
    private ExtendedWebElement jobTitleButton;

    public AdminPageBase(WebDriver driver) {
        super(driver, Urls.ADMIN_PAGE_URL);
    }

    public JobListPageBase getJobListPage() {
        jobButton.click();
        jobTitleButton.click();
        return initPage(getDriver(), JobListPageBase.class);
    }
}

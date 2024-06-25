package com.solvd.pages.common.admin;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AdminPageBase extends AbstractAdminPage {
    @FindBy(xpath = "//span[contains(text(), 'Job')]/parent::li")
    private ExtendedWebElement jobButton;

    @FindBy(xpath = "//a[contains(text(), 'Job Titles')]/parent::li")
    private ExtendedWebElement jobTitleButton;

    public AdminPageBase(WebDriver driver) {
        super(driver);
    }

    public void clickJobButton() {
        jobButton.click();
    }

    public void clickJobTitleButton() {
        jobTitleButton.click();
    }

    public JobListPageBase getJobListPage() {
        clickJobButton();
        clickJobTitleButton();
        return initPage(getDriver(), JobListPageBase.class);
    }
}

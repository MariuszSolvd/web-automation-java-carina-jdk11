package com.solvd.pages.admin;

import com.solvd.pages.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends AbstractMenuPage {

    @FindBy(xpath = "//span[contains(text(), 'Job')]/parent::li")
    private WebElement jobButton;
    @FindBy(xpath = "//a[contains(text(), 'Job Titles')]/parent::li")
    private WebElement jobTitleButton;

    public AdminPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickJobButton() {
        clickWrapper(jobButton);
    }

    public void clickJobTitleButton() {
        clickWrapper(jobTitleButton);
    }

    public JobListPage getJobListPage() {
        clickJobButton();
        clickJobTitleButton();
        return new JobListPage(webDriver);
    }
}

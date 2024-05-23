package com.solvd.pages.admin;

import com.solvd.pages.LeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(), 'Job')]/parent::li")
    private ExtendedWebElement jobButton;
    @FindBy(xpath = "//a[contains(text(), 'Job Titles')]/parent::li")
    private ExtendedWebElement jobTitleButton;
    @Getter
    private LeftMenu leftMenu;

    public AdminPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickJobButton() {
        jobButton.click();
    }

    public void clickJobTitleButton() {
        jobTitleButton.click();
    }

    public JobListPage getJobListPage() {
        clickJobButton();
        clickJobTitleButton();
        return new JobListPage(getDriver());
    }
}

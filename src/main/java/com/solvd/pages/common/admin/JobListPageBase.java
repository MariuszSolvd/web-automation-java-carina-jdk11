package com.solvd.pages.common.admin;

import com.solvd.model.Job;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class JobListPageBase extends AbstractAdminPage {

    @Getter
    @FindBy(xpath = "//i[contains(@class, 'bi-plus')]/parent::button")
    private ExtendedWebElement addJobButton;

    @FindBy(xpath = "//div[@role ='table']")
    private ExtendedWebElement jobContainer;

    public JobListPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(jobContainer);
    }

    public AddJobPageBase clickAddJobButton() {
        addJobButton.click();
        return initPage(getDriver(), AddJobPageBase.class);
    }

    public abstract List<Job> getJobList();
}

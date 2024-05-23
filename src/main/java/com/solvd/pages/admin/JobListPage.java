package com.solvd.pages.admin;

import com.solvd.pages.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobListPage extends AbstractMenuPage {
    @FindBy(xpath = "//i[contains(@class, 'bi-plus')]/parent::button")
    private WebElement addJobButton;
    @FindBy(xpath = "//div[@class = 'oxd-table-card']/*")
    private List<WebElement> jobList;

    public JobListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddJobPage clickAddJobButton() {
        clickWrapper(addJobButton);
        return new AddJobPage(webDriver);
    }

    public List<WebElement> getJobList() {
        loadWebElementList(jobList);
        return jobList;
    }

}

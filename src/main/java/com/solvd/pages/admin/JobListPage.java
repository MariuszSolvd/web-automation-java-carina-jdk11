package com.solvd.pages.admin;

import com.solvd.pages.LeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobListPage extends AbstractPage {
    @FindBy(xpath = "//i[contains(@class, 'bi-plus')]/parent::button")
    private ExtendedWebElement addJobButton;
    @FindBy(xpath = "//div[@class = 'oxd-table-card']/*")
    private List<ExtendedWebElement> jobList;
    @Getter
    private LeftMenu leftMenu;

    public JobListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddJobPage clickAddJobButton() {
        addJobButton.click();
        return new AddJobPage(getDriver());
    }

    public List<ExtendedWebElement> getJobList() {
        return jobList;
    }

}

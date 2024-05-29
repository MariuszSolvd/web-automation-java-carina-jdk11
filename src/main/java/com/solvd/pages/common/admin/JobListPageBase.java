package com.solvd.pages.common.admin;

import com.solvd.pages.desktop.admin.AbstractAdminPage;
import com.solvd.pages.desktop.admin.AddJobPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class JobListPageBase extends AbstractAdminPage {

    @Getter
    @FindBy(xpath = "//div[@class = 'oxd-table-card']/*")
    protected List<ExtendedWebElement> jobList;

    public JobListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AddJobPageBase clickAddJobButton();
}

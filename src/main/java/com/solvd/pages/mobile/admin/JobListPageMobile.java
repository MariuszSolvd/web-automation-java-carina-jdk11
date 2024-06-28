package com.solvd.pages.mobile.admin;

import com.solvd.mapper.JobMapper;
import com.solvd.model.Job;
import com.solvd.pages.common.admin.JobListPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public abstract class JobListPageMobile extends JobListPageBase {

    @FindBy(xpath = "//div[@role ='rowgroup']/*")
    private List<ExtendedWebElement> jobList;

    public JobListPageMobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        getMenuByClick();
        leftMenu.getButtonByHref(href).click();
    }

    @Override
    public void getMenuByClick() {
        menuButton.click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(leftMenu.getBy()), 30);
    }

    public List<Job> getJobList() {
        return JobMapper.mapJobsToListMobile(jobList);
    }
}

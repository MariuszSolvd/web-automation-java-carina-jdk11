package com.solvd.pages.desktop.admin;

import com.solvd.mapper.JobMapper;
import com.solvd.model.Job;
import com.solvd.pages.common.admin.JobListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = JobListPageBase.class)
public class JobListPageDesktop extends JobListPageBase {
    @FindBy(xpath = "//div[@class = 'oxd-table-card']/*")
    private List<ExtendedWebElement> jobList;

    public JobListPageDesktop(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public List<ExtendedWebElement> getJobElements() {
        return jobList;
    }

    @Override
    public List<Job> getJobList(List<ExtendedWebElement> elements) {
        return JobMapper.mapJobsToListDesktop(elements);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }

}

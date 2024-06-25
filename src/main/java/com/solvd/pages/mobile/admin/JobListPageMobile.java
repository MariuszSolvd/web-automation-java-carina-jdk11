package com.solvd.pages.mobile.admin;

import com.solvd.mapper.JobMapper;
import com.solvd.model.Job;
import com.solvd.pages.common.admin.JobListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = JobListPageBase.class)
public class JobListPageMobile extends JobListPageBase {

    @FindBy(xpath = "//i[contains(@class, 'bi-plus')]/parent::button")
    private ExtendedWebElement addJobButton;

    @FindBy(xpath = "//div[@role ='rowgroup']/*")
    private List<ExtendedWebElement> jobList;

    public JobListPageMobile(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public List<ExtendedWebElement> getJobElements() {
        return jobList;
    }

    @Override
    public List<Job> getJobList(List<ExtendedWebElement> elements) {
        return JobMapper.mapJobsToListMobile(elements);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }
}

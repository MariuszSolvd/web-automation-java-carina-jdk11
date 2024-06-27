package com.solvd.pages.ios.admin;

import com.solvd.mapper.JobMapper;
import com.solvd.model.Job;
import com.solvd.pages.common.admin.JobListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = JobListPageBase.class)
public class JobListPageIOs extends JobListPageBase {

    @FindBy(xpath = "//i[contains(@class, 'bi-plus')]/parent::button")
    private ExtendedWebElement addJobButton;

    @FindBy(xpath = "//div[@role ='rowgroup']/*")
    private List<ExtendedWebElement> jobList;

    public JobListPageIOs(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public List<Job> getJobList() {
        return JobMapper.mapJobsToListMobile(jobList);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }
}

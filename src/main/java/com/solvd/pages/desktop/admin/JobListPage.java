package com.solvd.pages.desktop.admin;

import com.solvd.pages.common.admin.AddJobPageBase;
import com.solvd.pages.common.admin.JobListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = JobListPageBase.class)
public class JobListPage extends JobListPageBase {
    @FindBy(xpath = "//i[contains(@class, 'bi-plus')]/parent::button")
    private ExtendedWebElement addJobButton;
    @FindBy(xpath = "//div[@class = 'oxd-table-card']/*")
    private List<ExtendedWebElement> jobList;

    public JobListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
    }

    public AddJobPageBase clickAddJobButton() {
        addJobButton.click();
        return initPage(getDriver(), AddJobPageBase.class);
    }

}

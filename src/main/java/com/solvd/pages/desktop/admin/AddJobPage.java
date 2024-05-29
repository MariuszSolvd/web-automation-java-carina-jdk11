package com.solvd.pages.desktop.admin;

import com.solvd.pages.common.admin.AddJobPageBase;
import com.solvd.pages.common.admin.JobListPageBase;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AddJobPageBase.class)
public class AddJobPage extends AddJobPageBase {

    @FindBy(xpath = "//div[@class = 'oxd-form-row']//input[contains(@class, 'oxd-input')]")
    private ExtendedWebElement jobTitleField;
    @FindBy(xpath = "//textarea[@placeholder = 'Type description here']")
    private ExtendedWebElement descriptionField;
    @FindBy(xpath = "//button[@type = 'submit']")
    private ExtendedWebElement saveButton;

    public AddJobPage(WebDriver webDriver) {
        super(webDriver);
        setUiLoadedMarker(descriptionField);
    }

    @Override
    public void inputJobTitle(String title) {
        jobTitleField.type(title);
    }

    @Override
    public void inputDescription(String description) {
        descriptionField.type(description);
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    public JobListPageBase addJobAndSave(String title, String description) {
        inputJobTitle(title);
        inputDescription(description);
        clickSaveButton();
        return initPage(getDriver(), JobListPageBase.class);
    }
}

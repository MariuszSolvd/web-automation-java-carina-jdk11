package com.solvd.pages.admin;

import com.solvd.pages.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.solvd.utilities.Urls.JOB_LIST_PAGE_URL;

public class AddJobPage extends AbstractMenuPage {

    @FindBy(xpath = "//div[@class = 'oxd-form-row']//input[contains(@class, 'oxd-input')]")
    WebElement jobTitleField;
    @FindBy(xpath = "//textarea[@placeholder = 'Type description here']")
    WebElement descriptionField;
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement saveButton;

    public AddJobPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputJobTitle(String title) {
        sendKeysWrapper(jobTitleField, title);
    }

    public void inputDescription(String description) {
        sendKeysWrapper(descriptionField, description);
    }

    public void clickSaveButton() {
        clickWrapper(saveButton);
    }

    public JobListPage addJobAndSave(String title, String description) {
        inputJobTitle(title);
        inputDescription(description);
        clickSaveButton();
        waitForUrl(JOB_LIST_PAGE_URL);
        return new JobListPage(webDriver);
    }
}

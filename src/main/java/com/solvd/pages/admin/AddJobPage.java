package com.solvd.pages.admin;

import com.solvd.pages.LeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddJobPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'oxd-form-row']//input[contains(@class, 'oxd-input')]")
    private ExtendedWebElement jobTitleField;
    @FindBy(xpath = "//textarea[@placeholder = 'Type description here']")
    private ExtendedWebElement descriptionField;
    @FindBy(xpath = "//button[@type = 'submit']")
    private ExtendedWebElement saveButton;
    @Getter
    LeftMenu leftMenu;

    public AddJobPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputJobTitle(String title) {
        jobTitleField.type(title);
    }

    public void inputDescription(String description) {
        descriptionField.type(description);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public JobListPage addJobAndSave(String title, String description) {
        inputJobTitle(title);
        inputDescription(description);
        clickSaveButton();
        return new JobListPage(getDriver());
    }
}

package com.solvd.pages.common.admin;

import com.solvd.pages.common.AbstractPageWithLeftMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public abstract class AddJobPageBase extends AbstractPageWithLeftMenu {
    @FindBy(xpath = "//div[@class = 'oxd-form-row']//input[contains(@class, 'oxd-input')]")
    private ExtendedWebElement jobTitleField;

    @FindBy(xpath = "//textarea[@placeholder = 'Type description here']")
    private ExtendedWebElement descriptionField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private ExtendedWebElement saveButton;

    public AddJobPageBase(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(saveButton);

    }

    public void clickMenuButtonByHref(String href) {
        leftMenu.getButtonByHref(href).click();
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

    public JobListPageBase addJobAndSave(String title, String description) {
        inputJobTitle(title);
        inputDescription(description);
        clickSaveButton();
        return initPage(getDriver(), JobListPageBase.class);
    }
}

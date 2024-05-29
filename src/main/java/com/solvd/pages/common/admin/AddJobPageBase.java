package com.solvd.pages.common.admin;

import com.solvd.pages.desktop.admin.AbstractAdminPage;
import org.openqa.selenium.WebDriver;

public abstract class AddJobPageBase extends AbstractAdminPage {

    public AddJobPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void inputJobTitle(String title);

    public abstract void inputDescription(String description);

    public abstract void clickSaveButton();

    public abstract JobListPageBase addJobAndSave(String title, String description);
}

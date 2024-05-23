package com.solvd.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeWrapper {

    private WebElement employee;

    public EmployeeWrapper(WebElement employee) {
        this.employee = employee;
    }

    public void clickDeleteButton() {
        WebElement deleteButton = employee.findElement(By.xpath(".//i[contains(@class, 'bi-trash')]/parent::button"));
        deleteButton.click();
    }
}

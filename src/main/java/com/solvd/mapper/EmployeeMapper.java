package com.solvd.mapper;

import com.solvd.model.Employee;
import com.solvd.pages.common.pim.EmployeePageBase;
import com.solvd.pages.desktop.pim.EmployeePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmployeeMapper {

    public static Employee mapToEmployeeFromEmployeePage(EmployeePageBase employeePage) {
        return Employee.builder()
                .firstName(employeePage.getFirstNameText())
                .middleName(employeePage.getMiddleNameText())
                .lastName(employeePage.getLastNameText())
                .idEmployee(employeePage.getIdEmployeeText())
                .build();
    }

    public static Employee mapToEmployeeFromWebElement(WebElement webElement) {
        List<WebElement> cells = webElement.findElements(By.xpath(".//*[@role='cell']"));
        String[] names = cells.get(2).getText().split(" ");

        String firstName = names[0];
        String middleName = null;

        if (names.length > 1) {
            middleName = names[1];
        }

        return Employee.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(cells.get(3).getText())
                .idEmployee(cells.get(1).getText())
                .build();
    }

    public static List<Employee> mapListToEmployees(List<ExtendedWebElement> elements) {
        return elements.stream()
                .map(EmployeeMapper::mapToEmployeeFromWebElement)
                .toList();
    }
}

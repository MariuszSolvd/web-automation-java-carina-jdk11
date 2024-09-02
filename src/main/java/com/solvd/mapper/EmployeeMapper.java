package com.solvd.mapper;

import com.solvd.model.Employee;
import com.solvd.pages.common.pim.EmployeePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static Employee mapToEmployeeFromEmployeePage(EmployeePageBase employeePage) {
        return Employee.builder()
                .firstName(employeePage.getFirstNameText())
                .middleName(employeePage.getMiddleNameText())
                .lastName(employeePage.getLastNameText())
                .idEmployee(employeePage.getIdEmployeeText())
                .build();
    }

    public static Employee mapToEmployeeFromWebElementDesktop(WebElement webElement) {
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

    public static Employee mapToEmployeeFromWebElementMobile(WebElement webElement) {
        List<WebElement> cells = webElement.findElements(By.xpath(".//*[@role='cell']"));
        String[] findId = cells.get(0).getText().split("\\R");
        String[] names = cells.get(2).getText().split("\\R");
        String[] name = names[1].split(" ");
        String middleName = null;
        if (name.length > 1) {
            middleName = name[1];
        }
        String[] lastName = cells.get(3).getText().split("\\R");

        return Employee.builder()
                .firstName(name[0])
                .middleName(middleName)
                .lastName(lastName[1])
                .idEmployee(findId[1])
                .build();
    }

    public static List<Employee> mapListToEmployeesDesktop(List<ExtendedWebElement> elements) {
        return elements.stream()
                .map(EmployeeMapper::mapToEmployeeFromWebElementDesktop)
                .collect(Collectors.toList());
    }

    public static List<Employee> mapListToEmployeesMobile(List<ExtendedWebElement> elements) {
        return elements.stream()
                .map(EmployeeMapper::mapToEmployeeFromWebElementMobile)
                .collect(Collectors.toList());
    }
}

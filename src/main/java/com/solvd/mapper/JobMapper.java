package com.solvd.mapper;

import com.solvd.model.Job;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobMapper {

    private static Job mapToJobFromWebElementDesktop(WebElement webElement) {
        List<WebElement> cells = webElement.findElements(By.xpath(".//*[@role='cell']"));
        return Job.builder()
                .title(cells.get(1).getText())
                .description(cells.get(2).getText())
                .build();
    }

    public static List<Job> mapJobsToListDesktop(List<ExtendedWebElement> elements) {
        return elements.stream()
                .map(JobMapper::mapToJobFromWebElementDesktop)
                .toList();
    }

    private static Job mapToJobFromWebElementMobile(WebElement webElement) {
        List<WebElement> cells = webElement.findElements(By.xpath(".//div[@class='card-center']/*"));
        String[] titles = cells.getFirst().getText().split("[\n\r]");
        String[] descriptions = cells.get(1).getText().split("[\n\r]");
        String description = null;
        if (descriptions.length > 1) {
            description = descriptions[1];
        }
        return Job.builder()
                .title(titles[1])
                .description(description)
                .build();
    }

    public static List<Job> mapJobsToListMobile(List<ExtendedWebElement> elements) {
        return elements.stream()
                .map(JobMapper::mapToJobFromWebElementMobile)
                .toList();
    }
}

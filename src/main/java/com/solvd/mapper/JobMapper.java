package com.solvd.mapper;

import com.solvd.model.Job;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobMapper {

    public static Job mapToJobFromWebElement(WebElement webElement) {
        List<WebElement> cells = webElement.findElements(By.xpath(".//*[@role='cell']"));
        return Job.builder()
                .title(cells.get(1).getText())
                .description(cells.get(2).getText())
                .build();
    }

    public static List<Job> mapListToJob(List<ExtendedWebElement> elements) {
        return elements.stream()
                .map(JobMapper::mapToJobFromWebElement)
                .toList();
    }
}

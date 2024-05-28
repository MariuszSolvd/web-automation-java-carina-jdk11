package com.solvd;

import com.solvd.mapper.EmployeeMapper;
import com.solvd.mapper.JobMapper;
import com.solvd.model.Employee;
import com.solvd.model.Job;
import com.solvd.pages.*;
import com.solvd.pages.pim.*;
import com.solvd.service.EmployeeService;
import com.solvd.service.JobService;
import com.solvd.service.LoginService;
import com.solvd.utilities.EmployeeWrapper;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.solvd.utilities.Urls.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTest extends AbstractTest {



    //Test case 1
    @Test(testName = "T1", threadPoolSize = 1, invocationCount = 1)
    public void shouldLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.isPageOpened();
    }

    //Test case 2
    @Test(testName = "T2", threadPoolSize = 1, invocationCount = 1)
    public void shouldNotLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("incorrect_user"), R.TESTDATA.get("incorrect_password"));
        assertTrue(loginPage.isAlertDisplayed(), "Alert is not visible");//<-
    }

    //Testing
    @Test(testName = "T3", threadPoolSize = 1, invocationCount = 1)
    public void testingTest() {
        DashboardPage dashboardPage = LoginService.successfulLogin(getDriver());
        dashboardPage.assertPageOpened();
        dashboardPage.clickMenuButtonByHref(PIM_PAGE_URL);

    }

    //Test case 3
    @Test(testName = "T3", threadPoolSize = 1, invocationCount = 1)
    public void shouldAddEmployee() {
        DashboardPage dashboardPage = LoginService.successfulLogin(getDriver());
        dashboardPage.assertPageOpened();
        dashboardPage.clickMenuButtonByHref(PIM_PAGE_URL);

        PimPage pimPage = new PimPage(getDriver());
        pimPage.assertPageOpened();

        AddEmployeePage addEmployeePage = pimPage.clickAddEmployeeButton();
        addEmployeePage.assertPageOpened();

        Employee employeeToAdd = EmployeeService.getEmployee();
        EmployeePage employeePage = addEmployeePage.addEmployee(employeeToAdd);
        employeePage.assertPageOpened();
        Employee employeeReceived = EmployeeMapper.mapToEmployeeFromEmployeePage(employeePage);

        assertEquals(employeeReceived, employeeToAdd, "Employee does not contain same data");
    }

    //Test case 4
    @Test(testName = "T4", threadPoolSize = 1, invocationCount = 1)
    public void shouldDeleteEmployee() {
        DashboardPage dashboardPage = LoginService.successfulLogin(getDriver());
        assertSuccessfulLogin(dashboardPage.getUrl());
        dashboardPage.clickMenuButtonByHref(PIM_PAGE_URL);
        PimPage pimPage = new PimPage(webDriver.get());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pimPage.getUrl(),
                EMPLOYEE_VIEW_PAGE_URL,
                "PIM URL mismatch");
        List<WebElement> employeeElementList = pimPage.getEmployeeList();
        System.out.println(employeeElementList);
        System.out.println(employeeElementList.getFirst());
        Employee employeeToDelete = EmployeeMapper.mapToEmployeeFromWebElement(employeeElementList.getFirst());
        EmployeeWrapper employeeWrapper = new EmployeeWrapper(employeeElementList.getFirst());
        employeeWrapper.clickDeleteButton();
        pimPage.clickDeleteConfirmationButton();
        pimPage.inputIdEmployee(employeeToDelete.getIdEmployee());
        pimPage.clickSearchEmployeeButton();
        List<Employee> employeeList = EmployeeMapper.mapListToEmployees(employeeElementList);
        softAssert.assertFalse(employeeList.contains(employeeToDelete), "Employee wasn't deleted");
        softAssert.assertAll();

    }
//
//    //Test case 5
//    @Test(testName = "T5", threadPoolSize = 1, invocationCount = 1)
//    public void shouldAddJobTitle() {
//        DashboardPage dashboardPage = login();
//        dashboardPage.clickMenuButtonByHref(ADMIN_BUTTON_URL);
//
//        AdminPage adminPage = new AdminPage(webDriver.get());
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(adminPage.getUrl(), ADMIN_PAGE_URL, "Admin URL mismatch");
//
//        JobListPage jobListPage = adminPage.getJobListPage();
//        softAssert.assertEquals(jobListPage.getUrl(), JOB_LIST_PAGE_URL, "Job List URL mismatch");
//
//        AddJobPage addJobPage = jobListPage.clickAddJobButton();
//        softAssert.assertEquals(addJobPage.getUrl(), JOB_ADD_PAGE_URL, "Job Add URL mismatch");
//
//        Job jobToAdd = JobService.getJob();
//        jobListPage = addJobPage.addJobAndSave(jobToAdd.getTitle(), jobToAdd.getDescription());
//        softAssert.assertEquals(jobListPage.getUrl(), JOB_LIST_PAGE_URL, "Job List URL mismatch");
//
//        List<WebElement> jobElements = jobListPage.getJobList();
//        List<Job> jobList = JobMapper.mapListToJob(jobElements);
//
//        softAssert.assertTrue(jobList.contains(jobToAdd));
//
//        softAssert.assertAll();
//    }

}

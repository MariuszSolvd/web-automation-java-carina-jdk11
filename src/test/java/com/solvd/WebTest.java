package com.solvd;

import com.solvd.mapper.EmployeeMapper;
import com.solvd.mapper.JobMapper;
import com.solvd.model.Employee;
import com.solvd.model.Job;
import com.solvd.pages.common.DashboardPageBase;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.admin.AddJobPageBase;
import com.solvd.pages.common.admin.JobListPageBase;
import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.solvd.pages.common.pim.EmployeePageBase;
import com.solvd.pages.common.pim.PimPageBase;
import com.solvd.pages.desktop.admin.*;
import com.solvd.service.EmployeeService;
import com.solvd.service.JobService;
import com.solvd.service.LoginService;
import com.solvd.utilities.EmployeeWrapper;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static com.solvd.utilities.Urls.*;
import static org.testng.Assert.*;

public class WebTest extends AbstractTest {

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        R.CONFIG.put("capabilities.browserName", browser);
    }



    //Test case 1
    @Test(testName = "T1", threadPoolSize = 1, invocationCount = 1)
    public void shouldLogin() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        DashboardPageBase dashboardPage = initPage(getDriver(), DashboardPageBase.class);

        dashboardPage.assertPageOpened();
    }

    //Test case 2
    @Test(testName = "T2", threadPoolSize = 1, invocationCount = 1)
    public void shouldNotLogin() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("incorrect_user"), R.TESTDATA.get("incorrect_password"));

        assertTrue(loginPage.isAlertDisplayed(), "Alert is not visible");//<-
    }

    //Test case 3
    @Test(testName = "T3", threadPoolSize = 1, invocationCount = 1)
    public void shouldAddEmployee() {
        LoginService loginService = new LoginService();
        DashboardPageBase dashboardPage = loginService.successfulLogin();
        dashboardPage.assertPageOpened();
        dashboardPage.clickMenuButtonByHref(PIM_PAGE_URL);

        PimPageBase pimPage = initPage(getDriver(), PimPageBase.class);
        pimPage.assertPageOpened();

        AddEmployeePageBase addEmployeePage = pimPage.clickAddEmployeeButton();
        addEmployeePage.assertPageOpened();

        Employee employeeToAdd = EmployeeService.getEmployee();
        EmployeePageBase employeePage = addEmployeePage.addEmployee(employeeToAdd);
        employeePage.assertPageOpened();
        Employee employeeReceived = EmployeeMapper.mapToEmployeeFromEmployeePage(employeePage);

        assertEquals(employeeReceived, employeeToAdd, "Employee does not contain same data");
    }

    //Test case 4
    @Test(testName = "T4", threadPoolSize = 1, invocationCount = 1)
    public void shouldDeleteEmployee() {
        LoginService loginService = new LoginService();
        DashboardPageBase dashboardPage = loginService.successfulLogin();
        dashboardPage.assertPageOpened();
        dashboardPage.clickMenuButtonByHref(PIM_PAGE_URL);

        PimPageBase pimPage = initPage(getDriver(), PimPageBase.class);
        pimPage.assertPageOpened();
        List<ExtendedWebElement> employeeElementList = pimPage.getEmployeeList();

        Employee employeeToDelete = EmployeeMapper.mapToEmployeeFromWebElement(employeeElementList.getFirst());

        EmployeeWrapper employeeWrapper = new EmployeeWrapper(employeeElementList.getFirst());
        employeeWrapper.clickDeleteButton();
        pimPage.clickDeleteConfirmationButton();
        pimPage.inputIdEmployee(employeeToDelete.getIdEmployee());
        pimPage.clickSearchEmployeeButton();
        List<Employee> employeeList = EmployeeMapper.mapListToEmployees(employeeElementList);

        assertFalse(employeeList.contains(employeeToDelete), "Employee wasn't deleted");
    }

    //Test case 5
    @Test(testName = "T5", threadPoolSize = 1, invocationCount = 1)
    public void shouldAddJobTitle() {
        LoginService loginService = new LoginService();
        DashboardPageBase dashboardPage = loginService.successfulLogin();
        dashboardPage.assertPageOpened();
        dashboardPage.clickMenuButtonByHref(ADMIN_BUTTON_URL);

        AdminPage adminPage = new AdminPage(getDriver());
        adminPage.assertPageOpened();

        JobListPageBase jobListPage = adminPage.getJobListPage();
        jobListPage.assertPageOpened();

        AddJobPageBase addJobPage = jobListPage.clickAddJobButton();
        addJobPage.assertPageOpened();

        Job jobToAdd = JobService.getJob();
        jobListPage = addJobPage.addJobAndSave(jobToAdd.getTitle(), jobToAdd.getDescription());
        jobListPage.assertPageOpened();

        List<ExtendedWebElement> jobElements = jobListPage.getJobList();
        List<Job> jobList = JobMapper.mapListToJob(jobElements);

        assertTrue(jobList.contains(jobToAdd));
    }

    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}

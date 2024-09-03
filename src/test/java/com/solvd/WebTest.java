package com.solvd;

import com.solvd.mapper.EmployeeMapper;
import com.solvd.model.Employee;
import com.solvd.model.Job;
import com.solvd.pages.common.PageWithLeftMenuBase;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.admin.AddJobPageBase;
import com.solvd.pages.common.admin.AdminPageBase;
import com.solvd.pages.common.admin.JobListPageBase;
import com.solvd.pages.common.pim.AddEmployeePageBase;
import com.solvd.pages.common.pim.EmployeePageBase;
import com.solvd.pages.common.pim.PimPageBase;
import com.solvd.service.EmployeeService;
import com.solvd.service.JobService;
import com.solvd.service.LoginService;
import com.solvd.utilities.EmployeeWrapper;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

public class WebTest extends AbstractTest {

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        R.CONFIG.put("capabilities.browserName", browser);
    }



    //Test case 1
    @Test(testName = "T1", threadPoolSize = 1, priority = 1)
    public void shouldLogin() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        PageWithLeftMenuBase pageWithLeftMenuBase = initPage(getDriver(), PageWithLeftMenuBase.class);
        pageWithLeftMenuBase.assertPageOpened();
    }

    //Test case 2
    @Test(testName = "T2", threadPoolSize = 1, priority = 2)
    public void shouldNotLogin() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("incorrect_user"), R.TESTDATA.get("incorrect_password"));

        assertTrue(loginPage.isAlertDisplayed(), "Alert is not visible");
    }

    //Test case 3
    @Test(testName = "T3", threadPoolSize = 1, priority = 3)
    public void shouldAddEmployee() {
        LoginService loginService = new LoginService();
        PimPageBase pimPage = loginService.successfulLogin(PimPageBase.class);

        AddEmployeePageBase addEmployeePage = pimPage.clickAddEmployeeButton();
        addEmployeePage.assertPageOpened();

        Employee employeeToAdd = EmployeeService.getEmployee();
        EmployeePageBase employeePage = addEmployeePage.addEmployee(employeeToAdd);
        employeePage.assertPageOpened();
        employeePage.waitForDataToLoad();
        Employee employeeReceived = EmployeeMapper.mapToEmployeeFromEmployeePage(employeePage);
        assertEquals(employeeReceived, employeeToAdd, "Employee does not contain same data");

    }

    //Test case 4
    @Test(testName = "T4", threadPoolSize = 1, priority = 4)
    public void shouldDeleteEmployee() {
        LoginService loginService = new LoginService();
        PimPageBase pimPage = loginService.successfulLogin(PimPageBase.class);
        pimPage.waitForDataToLoad();

        //Get list from PIM Page
        List<ExtendedWebElement> employeeElementList = pimPage.getEmployeeList();
        //Get element to delete
        Employee employeeToDelete = pimPage.mapToEmployee(employeeElementList.get(0));
        EmployeeWrapper employeeWrapper = new EmployeeWrapper(employeeElementList.get(0));
        employeeWrapper.clickDeleteButton();
        pimPage.clickDeleteConfirmationButton();
        //Search for deleted employee
        pimPage.inputIdEmployee(employeeToDelete.getIdEmployee());
        pimPage.clickSearchEmployeeButton(); //empty
        //Creating list of current(after deletion) employee list
        List<Employee> employeeList = pimPage.mapToEmployeeList(employeeElementList);

        assertFalse(employeeList.contains(employeeToDelete), "Employee wasn't deleted");
    }

    //Test case 5
    @Test(testName = "T5", threadPoolSize = 1, priority = 5)
    public void shouldAddJobTitle() {
        LoginService loginService = new LoginService();
        AdminPageBase adminPage = loginService.successfulLogin(AdminPageBase.class);
        //From Admin Page click on job button and pick Job Titles
        JobListPageBase jobListPage = adminPage.getJobListPage();
        jobListPage.assertPageOpened();
        //Click on add button and navigate to Add Job Page
        AddJobPageBase addJobPage = jobListPage.clickAddJobButton();
        addJobPage.assertPageOpened();
        //Adding auto-generated job and redirection to JobListPage again
        Job jobToAdd = JobService.getJob();
        jobListPage = addJobPage.addJobAndSave(jobToAdd.getTitle(), jobToAdd.getDescription());
        jobListPage.assertPageOpened();
        //Getting new(current) job list and asserting if auto-generated job has been added
        List<Job> jobList = jobListPage.getJobList();

        assertTrue(jobList.contains(jobToAdd));
    }

    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}

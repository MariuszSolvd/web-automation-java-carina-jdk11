package com.solvd.utilities;

import static com.solvd.utilities.PropertiesUtil.get;

public interface Urls {
    String BASE_URL = get("base.url");
    String LOGIN_PAGE_URL = BASE_URL + get("login.url");
    String DASHBOARD_PAGE_URL = BASE_URL + get("dashboard.url");
    String EMPLOYEE_VIEW_PAGE_URL = BASE_URL + get("viewEmployeeList.url");
    String EMPLOYEE_ADD_PAGE_URL = BASE_URL + get("addEmployee.url");
    String ADMIN_BUTTON_URL = BASE_URL + get("admin.href");
    String PIM_PAGE_URL = BASE_URL + get("pim.url");
    String LEAVE_PAGE_URL = BASE_URL + get("leave.url");
    String TIME_PAGE_URL = BASE_URL + get("time.url");
    String RECRUITMENT_PAGE_URL = BASE_URL + get("recruitment.url");
    String MY_INFO_PAGE_URL = BASE_URL + get("myInfo.url");
    String PERFORMANCE_PAGE_URL = BASE_URL + get("performance.url");
    String DIRECTORY_PAGE_URL = BASE_URL + get("directory.url");
    String MAINTENANCE_PAGE_URL = BASE_URL + get("maintenance.url");
    String CLAIM_PAGE_URL = BASE_URL + get("claim.url");
    String BUZZ_PAGE_URL = BASE_URL + get("buzz.url");
    String DETAIL_EMPLOYEE_PAGE_URL = BASE_URL + get("detailEmployee.url");
    String ADMIN_PAGE_URL = BASE_URL + get("admin.url");
    String JOB_LIST_PAGE_URL = BASE_URL + get("jobList.url");
    String JOB_ADD_PAGE_URL = BASE_URL + get("jobAdd.url");
}
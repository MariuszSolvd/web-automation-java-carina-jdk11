package com.solvd.utilities;

import static com.zebrunner.carina.utils.R.CONFIG;

public interface Urls {
    String BASE_URL = CONFIG.get("url");
    String LOGIN_PAGE_URL = BASE_URL + CONFIG.get("login.url");
    String DASHBOARD_PAGE_URL = BASE_URL + CONFIG.get("dashboard.url");
    String EMPLOYEE_VIEW_PAGE_URL = BASE_URL + CONFIG.get("viewEmployeeList.url");
    String EMPLOYEE_ADD_PAGE_URL = BASE_URL + CONFIG.get("addEmployee.url");
    String ADMIN_BUTTON_URL = BASE_URL + CONFIG.get("admin.href");
    String PIM_PAGE_URL = BASE_URL + CONFIG.get("pim.url");
    String LEAVE_PAGE_URL = BASE_URL + CONFIG.get("leave.url");
    String TIME_PAGE_URL = BASE_URL + CONFIG.get("time.url");
    String RECRUITMENT_PAGE_URL = BASE_URL + CONFIG.get("recruitment.url");
    String MY_INFO_PAGE_URL = BASE_URL + CONFIG.get("myInfo.url");
    String PERFORMANCE_PAGE_URL = BASE_URL + CONFIG.get("performance.url");
    String DIRECTORY_PAGE_URL = BASE_URL + CONFIG.get("directory.url");
    String MAINTENANCE_PAGE_URL = BASE_URL + CONFIG.get("maintenance.url");
    String CLAIM_PAGE_URL = BASE_URL + CONFIG.get("claim.url");
    String BUZZ_PAGE_URL = BASE_URL + CONFIG.get("buzz.url");
    String DETAIL_EMPLOYEE_PAGE_URL = BASE_URL + CONFIG.get("detailEmployee.url");
    String ADMIN_PAGE_URL = BASE_URL + CONFIG.get("admin.url");
    String JOB_LIST_PAGE_URL = BASE_URL + CONFIG.get("jobList.url");
    String JOB_ADD_PAGE_URL = BASE_URL + CONFIG.get("jobAdd.url");
}
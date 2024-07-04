package com.solvd.service;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.PageWithLeftMenuBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class LoginService implements ICustomTypePageFactory {

    public <T extends PageWithLeftMenuBase> T successfulLogin(Class<T> page) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        loginPage.logIn(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        PageWithLeftMenuBase pageWithLeftMenuBase = initPage(getDriver(), PageWithLeftMenuBase.class);
        pageWithLeftMenuBase.assertPageOpened();

        T targetPage = initPage(getDriver(), page);
        targetPage.open();
        targetPage.assertPageOpened();
        return  targetPage;
    }
}

package com.solvd;

import com.solvd.app.BrowserPageBase;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.PageWithLeftMenuBase;
import com.solvd.service.LoginService;
import com.solvd.utilities.context.ContextUtils;
import com.solvd.utilities.context.View;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

public class ContextTest extends AbstractTest {

    @Test
    public void switchTab() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.open();
        LoginService loginService = new LoginService();
        PageWithLeftMenuBase pageWithLeftMenuBase = loginService.successfulLogin();
        pageWithLeftMenuBase.assertPageOpened();
        ContextUtils contextUtils = new ContextUtils();
        String currentContext = contextUtils.getCurrentContext();
        String currentWindow = getDriver().getWindowHandle();
        contextUtils.switchMobileContext(View.NATIVE.getViewName());
        BrowserPageBase browserPageBase = initPage(getDriver(), BrowserPageBase.class);
        browserPageBase.openNewTab();
        browserPageBase.openTabsContext();
        contextUtils.switchMobileContext(currentContext);
        getDriver().switchTo().window(currentWindow);
        loginPageBase = pageWithLeftMenuBase.logout();
        loginPageBase.assertPageOpened();
    }
}

package com.ebay.tests.login;
import com.ebay.pages.LoginPage;
import com.ebay.tests.BaseTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void login() throws InterruptedException, IOException, AWTException {



        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignInMenuOption();
        log.debug("Clicked on Sign in Menu");
        loginPage.fillUpLoginDetails("Scenario1");
        System.out.println("Success");
    }

}

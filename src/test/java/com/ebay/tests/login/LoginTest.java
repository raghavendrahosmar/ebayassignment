package com.ebay.tests.login;
import com.ebay.pages.LoginPage;
import com.ebay.tests.BaseTest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTest extends BaseTest {

    private Logger logger = Logger.getLogger(LoginTest.class);

    @Test
    public void login() throws InterruptedException, IOException, AWTException {

        PropertyConfigurator.configure("D:\\Automation\\Appium\\ebayassignment_raghavendra\\Log\\Log4j.properties");

        LoginPage loginPage = new LoginPage(driver);
        logger.info("Launched the driver");
        loginPage.clickSignInMenuOption();
        logger.debug("Clicked on Sign in Menu");
        loginPage.fillUpLoginDetails("Scenario1");
        System.out.println("Success");
    }

}

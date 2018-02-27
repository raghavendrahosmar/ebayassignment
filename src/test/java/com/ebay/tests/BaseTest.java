package com.ebay.tests;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.ebay.pages.BasePage;
import com.ebay.pages.LoginPage;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;

public class BaseTest {

    public BasePage basePage;
    public LoginPage loginPage;
    public AppiumDriver driver;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    @BeforeClass
    public void baseBeforeClass() throws IOException, InterruptedException{

        basePage = new BasePage(driver);
        driver = basePage.launchDriver();
        log.debug("Launching Appium driver");
    }

    @AfterClass
    public void baseAfterClass(){

        driver.quit();
        log.debug("Quitting the driver");
    }
}

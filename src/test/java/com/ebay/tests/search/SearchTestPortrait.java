package com.ebay.tests.search;

import com.ebay.pages.*;
import com.ebay.tests.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class SearchTestPortrait extends BaseTest {

    ExtentReports extent = new ExtentReports("D:/Automation/Appium/ebayassignment_raghavendra/Reports/EbayScrollSwipeTests.html");
    ExtentTest Testlog;
    BasePage basePage = new BasePage(driver);


    @AfterMethod
    public void aftermethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            // if a class/method passed it will print the log along with screen shot and method name
            String screenshot_path = Screenshot.createScreenshot(driver);
            String image = Testlog.addScreenCapture(screenshot_path);
            Testlog.log(LogStatus.PASS, result.getName(), image);

        } else {
            // if a class/method failed it will print the log along with screen shot and method name
            String screenshot_path = Screenshot.createScreenshot(driver);
            String image = Testlog.addScreenCapture(screenshot_path);
            Testlog.log(LogStatus.FAIL, result.getName(), image);
        }
        extent.endTest(Testlog);
    }

    @AfterSuite
    public void aftertest() throws Exception {
        Thread.sleep(6000);
        extent.flush();
        driver.quit();
    }

    @Test(priority = 0)
    public void searchProduct() throws IOException, InterruptedException {

        basePage.changeOrientationtoPortrait();
        log.debug("Changing orientation to Portrait");
        HomePage homepage = new HomePage(driver);
//        homepage.searchProduct("Scenario1");
//        log.debug("Searching a product");
//        homepage.navigatetoPDP();
//        log.debug("Navigating to the Product Description Page");

        BasePage.ScrollTo(driver);
        Testlog.log(LogStatus.INFO, "Scroll action performed");
        Thread.sleep(3000);

    }


    @Test(priority = 1)
    public void SwipeToNext() throws InterruptedException {
        Testlog = extent.startTest("Verify Scroll to Handpicked By Ebay category");
        BasePage.SwipeTo(driver);
        Testlog.log(LogStatus.INFO, "Swipe action performed");
        /*ProductPage productPage = new ProductPage(driver);
        productPage.clickonBuyItNow();
        log.debug("Clicked on Buy it now");*/
        Thread.sleep(4000);
        System.out.println("Success");
        extent.endTest(Testlog);

    }

    @Test(priority = 2)
    public void CliconMore() throws Exception {
        Testlog = extent.startTest("Verify click on More");
        Thread.sleep(2000);
        BasePage.MoreHandpicked(driver).click();
        Testlog.log(LogStatus.INFO, "Click action performed");

    }

    @Test(priority = 3)
    public void ScrollMore() throws Exception {
        Testlog = extent.startTest("Verify click on More");
        BasePage.ScrollToPlayitLoudProduct(driver);
        Testlog.log(LogStatus.INFO, "Scroll action performed(Play it Loud)");
    }


}

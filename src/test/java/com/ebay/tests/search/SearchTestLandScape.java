package com.ebay.tests.search;

import com.ebay.Utils.AppiumUtils;
import com.ebay.pages.BasePage;
import com.ebay.pages.HomePage;
import com.ebay.pages.ProductPage;
import com.ebay.tests.BaseTest;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTestLandScape extends BaseTest {



    @Test(priority = 1)
    public void searchProduct() throws IOException, InterruptedException {

        BasePage basePage = new BasePage(driver);
        basePage.changeOrientationtoLandscape();
        HomePage homepage = new HomePage(driver);
        homepage.searchProduct("Scenario1");
        log.debug("Searching a product");
        homepage.navigatetoPDP();
        log.debug("Navigating to the Product Description Page");
    }

    @Test(priority = 0)
    public void scrolltoBottomOfPLP() {

        BasePage basePage = new BasePage(driver);
        HomePage homepage = new HomePage(driver);
        homepage.scrollToMoreButton();
        log.debug("Scrolled to the botton of the page");

    }


    @Test(priority = 2)
    public void BuyItNow() throws InterruptedException {

        ProductPage productPage = new ProductPage(driver);
        productPage.clickonBuyItNow();
        log.debug("Clicked on Buy it now");
        Thread.sleep(4000);
        System.out.println("Success");
    }


}

package com.ebay.tests.purchase;

import com.ebay.pages.ProductPage;
import com.ebay.tests.BaseTest;
import org.testng.annotations.Test;

import static com.ebay.Utils.AppiumUtils.driver;

public class BuyProductAfterAddingToCart extends BaseTest {


    @Test
    public void BuyItNow() throws InterruptedException {
        System.out.println("llllSuccess");
        ProductPage productPage = new ProductPage(driver);
        Thread.sleep(10000);
        productPage.clickonBuyItNow();
        System.out.println("Success");
    }
}

package com.ebay.tests.purchase;

import com.ebay.pages.ProductPage;
import com.ebay.tests.BaseTest;
import org.testng.annotations.Test;

import static com.ebay.Utils.AppiumUtils.driver;

public class BuyProductAfterAddingToCart extends BaseTest {


    @Test
    public void BuyItNow(){

        ProductPage productPage = new ProductPage(driver);
        productPage.clickonBuyItNow();
        System.out.println("Success");
    }
}

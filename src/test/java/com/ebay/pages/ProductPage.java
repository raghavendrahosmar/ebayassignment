package com.ebay.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    public ProductPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id="com.ebay.mobile:id/button_bin")
    MobileElement buyItNowButton;

    public void clickonBuyItNow() {

        waitForElementDisplay(buyItNowButton);
        buyItNowButton.click();

    }
}

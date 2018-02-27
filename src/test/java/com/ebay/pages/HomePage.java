package com.ebay.pages;

import com.ebay.Utils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.io.IOException;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.TextView")
    MobileElement WelcomeMessage;

    @AndroidFindBy(id="com.ebay.mobile:id/search_box") MobileElement searchTextBox;
    @AndroidFindBy(id="com.ebay.mobile:id/search_src_text") MobileElement searchkeyTextBox;
    @AndroidFindBy(id="com.ebay.mobile:id/text") MobileElement firstItemAutoSuggest;
    @AndroidFindBy(id="com.ebay.mobile:id/cell_collection_item") MobileElement itemContainer;
    @AndroidFindBy(id="com.ebay.mobile:id/button_add_to_cart") MobileElement addtoCartButton;
    @AndroidFindBy(id="com.ebay.mobile:id/button_bin") MobileElement buyItNowButton;




    public void assertIfUsernameDisplayedOnSuccessfulLogin(String username) throws IOException {

        String[] testData = readCSV(username);

        waitForElementDisplay(WelcomeMessage);
        String welcomeMsg = WelcomeMessage.getText();
        Assert.assertTrue(welcomeMsg.contains(testData[1]));
        System.out.println("Username is displayed in the Welcome Message");
    }


    public void searchProduct (String username) throws IOException {

        String[] testData = readCSV(username);
        waitForElementDisplay(searchTextBox);
        searchTextBox.click();
        searchkeyTextBox.sendKeys(testData[3]);
        waitForElementDisplay(firstItemAutoSuggest);
        firstItemAutoSuggest.click();

    }

    public void navigatetoPDP () throws IOException, InterruptedException {
        waitForElementDisplay(itemContainer);

        List<MobileElement> productlist = driver.findElements(By.id("com.ebay.mobile:id/cell_collection_item"));
//         AppiumUtils.scroller();

        productlist.get(2).click();

        waitForElementDisplay(buyItNowButton);



    }


}

package com.ebay.pages;

import com.ebay.Utils.AppiumUtils;
import com.ebay.Utils.ObjectRepository;
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

import static com.ebay.Utils.ObjectRepository.*;

public class HomePage extends BasePage {


    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = WelcomeMessage_XPATH)
    MobileElement WelcomeMessage;

    @AndroidFindBy(id = searchTextBox_ID)
    MobileElement searchTextBox;

    @AndroidFindBy(id = searchkeyTextBox_ID)
    MobileElement searchkeyTextBox;

//    @AndroidFindBy(id="com.ebay.mobile:id/text") MobileElement firstItemAutoSuggest;

    @AndroidFindBy(xpath = firstItemAutoSuggest_XPATH)
    MobileElement firstItemAutoSuggest;

    @AndroidFindBy(id = itemContainer_ID)
    MobileElement itemContainer;

    @AndroidFindBy(id = addtoCartButton_ID)
    MobileElement addtoCartButton;
    @AndroidFindBy(id = buyItNowButton_ID)
    MobileElement buyItNowButton;

    @AndroidFindBy(xpath = moreButton_XPATH)
    MobileElement moreButton;


    public void assertIfUsernameDisplayedOnSuccessfulLogin(String username) throws IOException {

        String[] testData = readCSV(username);

        waitForElementDisplay(WelcomeMessage);
        String welcomeMsg = WelcomeMessage.getText();
        Assert.assertTrue(welcomeMsg.contains(testData[1]));
        System.out.println("Username is displayed in the Welcome Message");
    }


    public void searchProduct(String username) throws IOException {

        String[] testData = readCSV(username);
        waitForElementDisplay(searchTextBox);
        searchTextBox.click();
        searchkeyTextBox.sendKeys(testData[3]);
        waitForElementDisplay(firstItemAutoSuggest);
        firstItemAutoSuggest.click();

    }

    public void scrollToMoreButton() {
        scrolltoElement(moreButton);

    }


    public void navigatetoPDP() throws IOException, InterruptedException {
        waitForElementDisplay(itemContainer);

        List<MobileElement> productlist = driver.findElements(By.id("com.ebay.mobile:id/cell_collection_item"));
//         AppiumUtils.scroller();

        productlist.get(2).click();

        waitForElementDisplay(buyItNowButton);


    }


}

package com.ebay.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.ebay.mobile:id/home")
    MobileElement menuButton;
    @AndroidFindBy(id = "com.ebay.mobile:id/textview_sign_out_status")
    MobileElement signInMenuButton;

    @AndroidFindBy(id = "com.ebay.mobile:id/button_register")
    MobileElement registerButton;
    @AndroidFindBy(id = "firstname")
    MobileElement firstNameTextfield;
    @AndroidFindBy(id = "lastname")
    MobileElement lastNameTextfield;
    @AndroidFindBy(id = "email")
    MobileElement emailTextfield;
    @AndroidFindBy(id = "PASSWORD")
    MobileElement passwordTextfield;

    @AndroidFindBy(id = "ppaFormSbtBtn")
    MobileElement signInButton;


    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.EditText[1]")
    MobileElement usernameTextfield;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    MobileElement passwordTextField;


    @AndroidFindBy(accessibility = "Submit")
    MobileElement submitButton;//Welcome  !
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.TextView")
    MobileElement WelcomeMessage;


    public LoginPage clickSignInMenuOption() {


        waitForElementDisplay(menuButton);
        menuButton.click();

        signInMenuButton.click();

        return new LoginPage(driver);

    }


    public LoginPage fillUpLoginDetails(String username) throws IOException, AWTException {

        String[] testData = readCSV(username);

        usernameTextfield.sendKeys(testData[1]);

        passwordTextField.sendKeys(testData[2]);

        click(submitButton);

        return new LoginPage(driver);
    }

    public LoginPage registerNewUser(String username) throws IOException {

        String[] testData = readCSV(username);

        usernameTextfield.sendKeys(testData[1]);
        passwordTextField.sendKeys(testData[2]);
        signInButton.click();

        submitButton.click();

        return new LoginPage(driver);
    }

    public void assertIfUsernameDisplayedOnSuccessfulLogin(String username) throws IOException {

        String[] testData = readCSV(username);

        waitForElementDisplay(WelcomeMessage);
        String welcomeMsg = WelcomeMessage.getText();
        Assert.assertTrue(welcomeMsg.contains(testData[1]));
        System.out.println("Username is displayed in the Welcome Message");
    }

    public void assertIfOnTheSamePage() {
        try {
            Assert.assertTrue(usernameTextfield.isDisplayed(), "Error! Unexpectedly we're not in the login page");
        } catch (Exception e) {
            System.out.println("TEST FAILED");
            System.out.println("ERROR!!! Even after inputting a wrong data we're still able to pass the login");
        }
    }


}

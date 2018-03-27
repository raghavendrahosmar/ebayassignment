package com.ebay.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;

import static com.ebay.Utils.ObjectRepository.*;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = menuButton_ID)
    MobileElement menuButton;
    @AndroidFindBy(id = signInMenuButton_ID)
    MobileElement signInMenuButton;

    @AndroidFindBy(id = registerButton_ID)
    MobileElement registerButton;
    @AndroidFindBy(id = firstNameTextfield_ID)
    MobileElement firstNameTextfield;
    @AndroidFindBy(id = lastNameTextfield_ID)
    MobileElement lastNameTextfield;
    @AndroidFindBy(id = emailTextfield_ID)
    MobileElement emailTextfield;
    @AndroidFindBy(id = passwordTextfield_ID)
    MobileElement passwordTextfield;

    @AndroidFindBy(id = signInButton_ID)
    MobileElement signInButton;


    @AndroidFindBy(xpath = usernameTextfield_XPATH)
    MobileElement usernameTextfield;
    @AndroidFindBy(xpath = passwordTextField_XPATH)
    MobileElement passwordTextField;


    @AndroidFindBy(accessibility = submitButton_ACCESSIBILITY)
    MobileElement submitButton;//Welcome  !
    @AndroidFindBy(xpath = WelcomeMessage_XPATH)
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

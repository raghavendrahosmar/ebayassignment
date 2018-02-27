package com.ebay.pages;

import com.ebay.Utils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;

public class BasePage extends AppiumUtils {


    public AppiumDriver driver;

    public BasePage(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public AppiumDriver launchDriver() throws IOException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //incase if you want run on an emulator and app not already installed on the device

//		capabilities.setCapability("deviceName", "Android Emulator");
//		capabilities.setCapability("avd", "AVDNexus7");

        //on Real device and app not already installed on the device

        capabilities.setCapability("deviceName", "0a612838");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        System.out.println("Launching app from location " + System.getProperty("user.dir") + "\\src\\test\\resources\\apks\\com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");
        capabilities.setCapability("app", System.getProperty("user.dir") + "\\src\\test\\resources\\apks\\com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");//apk location
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); // initializing the driver

        //if app already installed we may use package and activity names to control.

		capabilities.setCapability("appPackage","com.ebay.mobile");
		capabilities.setCapability("appActivity","com.ebay.mobile.MainActivity");
        return driver;
    }

    public void waitForElementDisplay(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void changeOrientationtoLandscape() throws InterruptedException {
        //Get and print current screen orientation.
        System.out.println("Current screen orientation Is : " + driver.getOrientation());

        //Changing screen Orientation to LANDSCAPE.
        driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
        //Get and print screen orientation after changing It.
        System.out.println("Now screen orientation Is : " + driver.getOrientation());
        Thread.sleep(5000);

    }

    public void changeOrientationtoPortrait() throws InterruptedException {

        System.out.println("Changing screen Orientation to PORTRAIT.");
        //Changing screen Orientation to PORTRAIT.
        driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
        //Get and print screen orientation after changing It.
        System.out.println("Now screen orientation Is : " + driver.getOrientation());
        Thread.sleep(5000);

    }


}

package com.ebay.pages;

import com.ebay.Utils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.net.URL;

public class BasePage extends AppiumUtils {


    public AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        super(driver);
//        this.driver = driver;
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
        System.out
                .println("Launching app from location "
                        + System.getProperty("user.dir")
                        + "\\src\\test\\resources\\apks\\com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");

        capabilities
                .setCapability(
                        "app", System.getProperty("user.dir")
                                + "\\src\\test\\resources\\apks\\com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");//apk location

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities); // initializing the driver

        //if app already installed we may use package and activity names to control.

        capabilities.setCapability("appPackage", "com.ebay.mobile");
        capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
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

    public void click(MobileElement element) {
        element.click();
    }

    public void scroller() throws IOException {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(0, 0).moveTo(1000, 0).release().perform();
        System.out.println("Screen Scrolled ");
    }

    //    This method is used to scroll the screen such that a particular webelement is visible
    public void scrolltoElement(MobileElement element) {
        JavascriptExecutor Executor = ((JavascriptExecutor) driver);
        Executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebElement MoreHandpicked(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//android.widget.Button[@content-desc='more Handpicked by eBay']"));
        return element;
    }

    public static WebElement ScrollTo(WebDriver driver) {
        String text = "Handpicked by eBay";
        WebElement element = driver
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"" + text + "\"));"));
        return element;
    }
    public static WebElement ScrollToPlayitLoudProduct(WebDriver driver) {
        String text = "Play It Loud";
        WebElement element = driver
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"" + text + "\"));"));
        return element;
    }

    public static WebElement SwipeTo(WebDriver driver) {
        String text = "Binge Time";
        return driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector().resourceIdMatches(\"com.ebay.mobile:id/carousel_list\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().text(\"" + text + "\"));"));
        // This method is used to swipe the screen
    }

    //    This method is used to swipe the screen

    public void swipe(MobileElement element1, MobileElement element2) {
        TouchAction ta = new TouchAction(driver);
        ta.press(element1).moveTo(element2).release().perform();

    }


}

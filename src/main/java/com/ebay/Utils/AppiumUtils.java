package com.ebay.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.HashMap;

public class AppiumUtils extends JavaUtils {

    public static AppiumDriver driver;

//    public AppiumUtils(AppiumDriver driver) {
//        this.driver = driver;
//    }

    //codes for scroll, swipe, click, etc....

    public static void click(MobileElement element) {
        element.click();
    }

    public static void scroller() throws IOException {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(0, 0).moveTo(1000, 0).release().perform();
        System.out.println("Screen Scrolled ");
    }

    //    This method is used to scroll the screen such that a particular webelement is visible
    public static void scrolltoElement(MobileElement element) {
        JavascriptExecutor Executor = ((JavascriptExecutor) driver);
        Executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //    This method is used to swipe the screen

    public static void swipe(MobileElement element1, MobileElement element2) {
        TouchAction ta = new TouchAction(driver);
        ta.press(element1).moveTo(element2).release().perform();

    }


}

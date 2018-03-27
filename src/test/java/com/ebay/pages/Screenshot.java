package com.ebay.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Screenshot {

    static String reportLocation = "D:/Automation/Appium/ebayassignment_raghavendra/Reports/screensots.html";
    static String imageLocation = "images/";
    public static String createScreenshot(WebDriver driver) {

        UUID uuid = UUID.randomUUID();

        // generate screenshot as a file object
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // copy file object to designated location
            FileUtils.copyFile(scrFile, new File("D:/Automation/Appium/ebayassignment_raghavendra/Reports/screensots.html" + imageLocation + uuid + ".png"));
        } catch (IOException e) {
            System.out.println("Error while generating screenshot:\n" + e.toString());
        }
        return reportLocation + imageLocation + uuid + ".png";
    }


}

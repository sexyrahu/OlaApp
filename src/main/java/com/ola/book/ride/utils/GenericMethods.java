package com.ola.book.ride.utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.ini4j.Ini;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Set;


public class GenericMethods {
    public AndroidDriver<AndroidElement> androidDriver;

    Logger logger;

    public GenericMethods() {
        super();

    }

    public GenericMethods(AndroidDriver<AndroidElement> driver) {
        this.androidDriver = driver;
        logger =Logger.getLogger("OLA Ride Booking");
        PropertyConfigurator.configure("Log4j.properties");
        BasicConfigurator.configure();
    }

    public static String PROJECT_ROOT_FOLDER = System.getProperty("user.dir");


    public String getValueByKey(String gettitle, String getKey) throws IOException {
        Ini ini = new Ini(new File(System.getProperty("user.dir") + "//TestData//androidapp//testdata.ini"));
        String value = ini.get(gettitle, getKey);
        if (value == null) {
            System.err.println("Enter Proper Title or Key!");
        }
        System.out.println(getKey + "-->" + value);
        return value;
    }

    public void SwitchToWebView() {
        Set<String> contextNames = androidDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        androidDriver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1
    }

    public void SwitchTNative() {
        Set<String> contextNames = androidDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        androidDriver.context("NATIVE_APP");
    }

    public void waitTillElementClickable() {

        try {
            Thread.sleep(4000);
        } catch (Exception e) {

        }
    }

    /**
     * @author Anu A Nambiar
     * Date : 17 Nov 2019
     * Method to capture screenshot and storing it in screenshot folder in the root directory
     */

    public void captureScreenshot(WebDriver driver, ITestResult result) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/screenshots/" + result.getName()+ ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
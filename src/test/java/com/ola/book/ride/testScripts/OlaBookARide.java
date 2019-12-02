package com.ola.book.ride.testScripts;

import com.ola.book.ride.objectRepo.Home.HomePageObjects;
import com.ola.book.ride.objectRepo.Login.LoginPageObjects;
import com.ola.book.ride.utils.DriverService;
import com.ola.book.ride.utils.GenericMethods;
import com.ola.book.ride.utils.StartAppiumService;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class OlaBookARide extends GenericMethods {

        AndroidDriver<AndroidElement> androidDriver;

        LoginPageObjects objLoginPageObject;
        GenericMethods objGenericMethods;
        HomePageObjects objHomePageObject;

        Logger logger;


        String testName = "Bookride";


        @Test(priority = 1)
        public void BookSingleRide() throws Exception {
            objLoginPageObject.Login(objGenericMethods.getValueByKey(testName, "phoneNumber"));
            objHomePageObject.booking(objGenericMethods.getValueByKey(testName, "drop"));
        }

        @BeforeTest(alwaysRun = true)
        public void setUp() throws MalformedURLException {
            DriverService mobileDrivers=new DriverService();
            StartAppiumService appiumServer = new StartAppiumService();
            appiumServer.startServer();
            logger = Logger.getLogger(OlaBookARide.class);
            PropertyConfigurator.configure("Log4j.properties");
            androidDriver = mobileDrivers.launchAndroidApp();
            logger.info("Ola app has been launched successfully.");
            androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            logger.info("Session time out been fixed for 20 seconds");
            objLoginPageObject = new LoginPageObjects(androidDriver);
            objHomePageObject = new HomePageObjects(androidDriver);
            objGenericMethods = new GenericMethods(androidDriver);
        }

        @AfterTest
        public void quit() {
            androidDriver.quit();
        }

        /**
         * @author Rahul Saxena
         * Date : 2 Dec 2019
         * Method implemented to capture screenshot for the failured occured.
         */

        @AfterMethod
        public void getResult(ITestResult result) throws IOException {
            if (result.getStatus() == ITestResult.FAILURE) {
                Reporter.log("captured sceenshot for the failure");
                objGenericMethods.captureScreenshot(androidDriver, result);
            }
        }

    }


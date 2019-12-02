package com.ola.book.ride.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverService extends  GenericMethods {

    public AndroidDriver<AndroidElement> androidDriver;



    public AndroidDriver<AndroidElement> launchAndroidApp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability("deviceName", "one plus one");
        capabilities.setCapability("UDID", "639e20fe");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.olacabs.customer");
        capabilities.setCapability("appActivity", "com.olacabs.customer.ui.SplashActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"120");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("gpsEnabled", true);

        File app = new File(PROJECT_ROOT_FOLDER+"/src/test/resources/Ola.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return androidDriver;
    }
}

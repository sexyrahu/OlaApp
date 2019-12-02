package com.ola.book.ride.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartAppiumService {
    private DesiredCapabilities cap;
    AppiumDriverLocalService appiumService;

    public void startServer() {


        //Setting up the cap

        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "true");
        //Building appium service
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
    }
}

package com.ola.book.ride.objectRepo.Home;

import com.ola.book.ride.utils.GenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageObjects extends GenericMethods {
    public WebElement element = null;
    GenericMethods objGenericMethods;
    AndroidDriver<AndroidElement> androidDriver;

    public HomePageObjects(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        objGenericMethods = new GenericMethods(androidDriver);
    }

    public AndroidElement getSelectCab() {
        return selectCab;
    }

    @FindBy(xpath = "//android.widget.RelativeLayout[contains(@content-desc,'Micro')]")
    public AndroidElement selectCab;


    public void clickOnSelectCab() {
        objGenericMethods.waitTillElementClickable();
        getSelectCab().click();
    }


    @FindBy(id = "com.olacabs.customer:id/button_ride_confirm")
    public AndroidElement Confirmbooking;

    public AndroidElement getConfirmbooking() {
        return Confirmbooking;
    }

    @FindBy(id = "com.olacabs.customer:id/drop_location_parent")
    public AndroidElement dropLocation;

    public AndroidElement getDropLocation() {
        return dropLocation;
    }

    @FindBy(id = "com.olacabs.customer:id/button_ride_now")
    public AndroidElement rideNow;

    public AndroidElement getRideNow() {
        return rideNow;
    }

    @FindBy(id = "com.olacabs.customer:id/searchEdit")
    public AndroidElement enterDropLocationfield;

    public AndroidElement getEnterDropLocationfield() {
        return enterDropLocationfield;
    }


    public AndroidElement getSelectDropLocation() {
        return selectDropLocation;
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Myntra Designs Pvt. Ltd.']")
    public AndroidElement selectDropLocation;


    public void booking(String drop) {
        objGenericMethods.waitTillElementClickable();
        getSelectCab().click();
        objGenericMethods.waitTillElementClickable();
        verifyDropLocationButtonVisibility();
        getDropLocation().click();
        getEnterDropLocationfield().sendKeys(drop);
        objGenericMethods.waitTillElementClickable();
        getSelectDropLocation().click();
        verifyRidenowButton();
        getRideNow().click();
        objGenericMethods.waitTillElementClickable();
        verifyConfirmBookingButtonVisibility();
        getConfirmbooking().click();

    }

    public void verifyRidenowButton() {
        Assert.assertTrue(getRideNow().isEnabled(), "Ride Now button is not enabled");
    }

    public void verifyDropLocationButtonVisibility() {
        Assert.assertTrue(getDropLocation().isEnabled(), "Drop location button is not enabled");
    }


    public void verifyConfirmBookingButtonVisibility() {
        Assert.assertTrue(getConfirmbooking().isEnabled(), "Confirm Booking button is not enabled");
    }

}

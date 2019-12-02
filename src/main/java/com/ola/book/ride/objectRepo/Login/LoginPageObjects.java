package com.ola.book.ride.objectRepo.Login;

import com.ola.book.ride.utils.GenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageObjects extends GenericMethods {
    GenericMethods objGenericMethods;


    AndroidDriver<AndroidElement> androidDriver;

    public LoginPageObjects(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        objGenericMethods = new GenericMethods(androidDriver);
    }

    @FindBy(id = "com.olacabs.customer:id/continue_with_phone_number")
    public AndroidElement LoginThroughPhoneNumber;

    public AndroidElement getloginThroughPhoneNumber() {
        return LoginThroughPhoneNumber;
    }

    @FindBy(id = "com.google.android.gms:id/cancel")
    public AndroidElement CancelPopUp;

    public AndroidElement getCancelPopUp() {
        return CancelPopUp;
    }

    @FindBy(id = "com.olacabs.customer:id/mobile_number")
    public AndroidElement Mobnumber;

    public AndroidElement getMobnumber() {
        return Mobnumber;
    }

    @FindBy(id = "com.olacabs.customer:id/blackButton")
    public AndroidElement NextButton;

    public WebElement getNextButton() {
        return NextButton;
    }

    @FindBy(id = "com.olacabs.customer:id/intro_close")
    public AndroidElement closeButton;

    public AndroidElement getCloseButton() {
        return closeButton;
    }

    public void Login(String phoneNumber) throws Exception {
        objGenericMethods.waitTillElementClickable();
        verifyLoginUsingPhoneNumberButton();
        getloginThroughPhoneNumber().click();
        objGenericMethods.waitTillElementClickable();
        getCancelPopUp().click();
        objGenericMethods.waitTillElementClickable();
        verifyMobileNumberInputFieldVisibility();
        getMobnumber().sendKeys(phoneNumber);
        objGenericMethods.waitTillElementClickable();
        verifyNextButtonVisibility();
        getNextButton().click();
        clickOnClose();
        objGenericMethods.waitTillElementClickable();

    }

    public void clickOnClose() {
        objGenericMethods.waitTillElementClickable();
        getCloseButton().click();
    }

    public void verifyLoginUsingPhoneNumberButton() {
        Assert.assertTrue(getloginThroughPhoneNumber().isEnabled(), "Login using Phone number button is not enabled");
    }

    public void verifyMobileNumberInputFieldVisibility() {
        Assert.assertTrue(getMobnumber().isEnabled(), "Mobile Number Input Field is not enabled");
    }

    public void verifyNextButtonVisibility() {
        Assert.assertTrue(getNextButton().isEnabled(), "Ride Now button is not enabled");
    }
}

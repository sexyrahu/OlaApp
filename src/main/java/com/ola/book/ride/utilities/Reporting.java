package com.ola.book.ride.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporting extends TestListenerAdapter {

    /**
     * @author Rahul Saxena
     * Date :  2 Dec 2019
     * Listener Class to generate Extent report
     */

        public ExtentHtmlReporter htmlReporter;
        public com.aventstack.extentreports.ExtentReports extentReports;
        public com.aventstack.extentreports.ExtentTest logger1;

        public void onStart(ITestContext iTestContext) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
            String repName = "TestReport" + timeStamp + ".html";
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + repName); //report location
            htmlReporter.loadConfig(System.getProperty("user.dir") + "/reporting.xml");

            extentReports = new com.aventstack.extentreports.ExtentReports();

            extentReports.attachReporter(htmlReporter);
            extentReports.setSystemInfo("HostName", "ola app");
            extentReports.setSystemInfo("User", "Anu A Nambiar");
            extentReports.setSystemInfo("Environment", "QA");


            htmlReporter.config()
                        .setDocumentTitle("Byjus : Ola Sample Android Automation Project"); //title of report
            htmlReporter.config()
                        .setReportName("Byjus : Ola Sample Android Automation Project"); //name of the report
            htmlReporter.config()
                        .setTheme(Theme.DARK);

        }

        public void onTestSuccess(ITestResult result) {

            logger1 = extentReports.createTest(result.getName());
            logger1.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
        }

        public void onTestFailure(ITestResult result) {
            htmlReporter.config()
                        .setAutoCreateRelativePathMedia(true);
            logger1 = extentReports.createTest(result.getName());
            logger1.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

            String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

            File file = new File(screenshotPath);
            if (file.exists()) {
                try {
                    logger1.fail("screenshot is below:" + logger1.addScreenCaptureFromPath(screenshotPath));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void onTestSkipped(ITestResult result) {
            logger1 = extentReports.createTest(result.getName());
            logger1.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
        }

        public void onFinish(ITestContext iTestContext) {
            extentReports.flush();
        }

    }


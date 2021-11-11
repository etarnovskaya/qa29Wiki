package com.telran.mob.wiki.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.telran.mob.wiki.tests.TestBase.app;


public class Listener implements ITestListener {
        Logger logger = LoggerFactory.getLogger(Listener.class);

        @Override
        public void onTestFailure(ITestResult result) {
            logger.error("Test failed " + result.getThrowable().toString());
            app.takeScreenShot(
                    "src/test/resources/imgs/screen_error" + System.currentTimeMillis() + ".png");
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            logger.info("Test passed");
        }


}

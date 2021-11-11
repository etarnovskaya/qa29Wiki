package com.telran.mob.wiki.tests;

import com.telran.mob.wiki.application.ApplicationManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Arrays;

@Listeners(Listener.class)
public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws InterruptedException, MalformedURLException {
        app.init();
    }

    @BeforeMethod
    public void startLogger(Method m, Object[] p) {
        logger.info("Start method " + m.getName() + " with parameters: " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method m) {
        logger.info("Stopped method " + m.getName());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}

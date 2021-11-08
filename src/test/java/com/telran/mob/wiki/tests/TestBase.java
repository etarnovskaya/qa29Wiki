package com.telran.mob.wiki.tests;

import com.telran.mob.wiki.application.ApplicationManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Arrays;

public class TestBase {

//    ToDo: to check BrowserType in selenium 4 hahaha

    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws InterruptedException, MalformedURLException {
        app.init();
    }

    @BeforeMethod
    public void startLogger(Method m, Object[] p){
        logger.info("Start method " + m.getName() + " with parameters: " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method m){
        logger.info("Stopped method " + m.getName());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }

}

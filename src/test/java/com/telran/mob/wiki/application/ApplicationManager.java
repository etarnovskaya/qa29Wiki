package com.telran.mob.wiki.application;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver driver;

    UserHelper user;
    ArticleHelper article;


    public void init() throws InterruptedException, MalformedURLException {
      //capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "andr_10");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("automationName", "Appium");
        caps.setCapability("appPackage", "org.wikipedia");
        caps.setCapability("appActivity", ".main.MainActivity");
        caps.setCapability("app", "C:\\Users\\Elena\\Dropbox\\Tel-ran\\Mobile\\apk\\wiki.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
       // wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(driver);
        article = new ArticleHelper(driver);

    }

    public UserHelper user() {
        return user;
    }

    public ArticleHelper article() {
        return article;
    }

    public void stop() {
        driver.quit();
    }


   // public String getAppVersion(){
       // return driver.findElement(By.id("app_version_res")).getText();
   // }

}

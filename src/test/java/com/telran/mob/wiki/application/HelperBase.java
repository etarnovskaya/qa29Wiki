package com.telran.mob.wiki.application;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class HelperBase {
    AppiumDriver driver;

    public HelperBase(AppiumDriver wd) {
        this.driver = wd;
    }

    public void type(By locator, String text) {
        if(text!=null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }




    public boolean isHomeButtonOnHeader(){
        return isElementPresent(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public boolean isTrelloButtonOnHeader(){
        return isElementPresent(By.cssSelector("[aria-label='Back to home']"));
    }

    public void retunToHomePage() {
        if (isTrelloButtonOnHeader()) {

           // click(By.cssSelector("[aria-label='Back to home']"));
            waitForElementAndClick(25, By.cssSelector("[aria-label='Back to home']"));
        } else
            waitForElementAndClick(25, By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void waitForElementAndClickOld() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Back to home']"))).click();
    }
//public void waitForElementAndClickNew(int time, By locator) {
//        new WebDriverWait(driver, Duration.ofSeconds(time))
//                .until(ExpectedConditions.presenceOfElementLocated(locator)).click();
//    }


    public void waitForElementAndClick(int timeOut, By locator) {
        new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public void closeKeyBoard() {
        driver.hideKeyboard();
    }
}

package com.telran.mob.wiki.application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class HelperBase {
    AppiumDriver driver;

    public HelperBase(AppiumDriver wd) {
        this.driver = wd;
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


    public boolean isHomeButtonOnHeader() {
        return isElementPresent(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public boolean isTrelloButtonOnHeader() {
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

    public void swipeToLeft(By locator) {
        TouchAction action = new TouchAction(driver);

        WebElement element = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(locator));

        int leftX = (int) (element.getLocation().getX() * 0.3);
        int rightX = (int) ((leftX + element.getSize().getWidth()) * 0.7);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();

        int middleY = (upperY + lowerY) / 2;

        action
                .longPress(PointOption.point(rightX, middleY))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();
    }
}

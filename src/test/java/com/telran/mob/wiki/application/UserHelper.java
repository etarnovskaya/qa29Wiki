package com.telran.mob.wiki.application;


import com.telran.mob.wiki.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase{
    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }
    public void login(User user) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), user.getEmail());
        Thread.sleep(2000);
        click(By.id("login"));
        type(By.name("password"), user.getPassword());
        click(By.id("login-submit"));
        Thread.sleep(15000);
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id=header-member-menu-logout]"));
        click(By.id("logout-submit"));
    }

    public void submitLogin() {
        click(By.id("login-submit"));
    }

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.cssSelector("#user"), user.getEmail());

        Thread.sleep(2000);
        click(By.id("login"));
        type(By.name("password"), user.getPassword());
    }

}

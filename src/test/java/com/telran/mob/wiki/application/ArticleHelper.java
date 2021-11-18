package com.telran.mob.wiki.application;

import com.telran.mob.wiki.model.Article;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticleHelper extends  HelperBase{
    By ARTICLE = By.id("page_list_item_container");
    By ADD_TO_FAVORITS = By.xpath("//*[@content-desc='Add this article to a reading list']");

    public ArticleHelper(AppiumDriver wd) {
        super(wd);
    }

    public void search(Article article) {
        tapOnTheSearchBar();
        typeInTheSearchBar(article.getTitle());

    }

    private void typeInTheSearchBar(String title) {
        type(By.id("search_src_text"), title);
    }

    private void tapOnTheSearchBar() {
        click(By.id("search_container"));
    }

    public String getTitleOfFirst() {
        return driver.findElement(By.id("page_list_item_title")).getText();

    }

    public void addToFavorits() {
        click(ADD_TO_FAVORITS);
       // click(By.xpath("//*[@content-desc='Add this article to a reading list']/.."));
    }

    public void open() {
        click(ARTICLE);
    }

    public void createListOfFavorits(String listTitle) throws InterruptedException {
        if(isElementPresent(By.xpath("//*[@text='GOT IT']"))){
            click(By.xpath("//*[@text='GOT IT']"));
        }
       // Thread.sleep(5000);
      //  click(By.id("create_button"));
      //  Thread.sleep(5000);
        type(By.id("text_input"), listTitle);
        click(By.xpath("//*[@text = 'OK']"));
    }

    public void close() {
        click(By.xpath("//*[@content-desc='Navigate up']"));
    }

    public void openMyLists() {
        click(By.xpath("//*[@content-desc='My lists']"));
    }

    public void openFavoritList(String my_list) {
        click(By.xpath("//*[@text='" + my_list +"']"));
      //  click(By.xpath("//*[@text='" + my_list +"']/../../../.."));
    }

    public void delete() {
        swipeToLeft(By.id("page_list_item_container"));
    }

}

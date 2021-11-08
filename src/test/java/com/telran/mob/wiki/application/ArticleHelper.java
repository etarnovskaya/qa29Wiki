package com.telran.mob.wiki.application;

import com.telran.mob.wiki.model.Article;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticleHelper extends  HelperBase{
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
}

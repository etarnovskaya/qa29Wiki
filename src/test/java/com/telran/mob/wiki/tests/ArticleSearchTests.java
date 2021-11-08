package com.telran.mob.wiki.tests;

import com.telran.mob.wiki.model.Article;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArticleSearchTests extends TestBase{
    @Test
    public void searchArticleTest(){
        String title = "Appium";
        app.article().search(new Article().setTitle(title));
        app.article().closeKeyBoard();
        String firstArticleTitle = app.article().getTitleOfFirst();

        //check Appium article present
        Assert.assertEquals(firstArticleTitle,title);
    }
}

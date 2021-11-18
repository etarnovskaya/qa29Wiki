package com.telran.mob.wiki.tests;

import com.telran.mob.wiki.model.Article;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArticleSearchTests extends TestBase {
    @Test
    public void searchArticleTest() throws InterruptedException {
        String title = "Appium";
        app.article().search(new Article().setTitle(title));
        app.article().closeKeyBoard();
        String firstArticleTitle = app.article().getTitleOfFirst();
        //   app.takeScreenShot("src/screenshot-" + System.currentTimeMillis());
        //check Appium article present
        Assert.assertEquals(firstArticleTitle, title);
    }

    @Test
    public void addTArticleToFavorits() throws InterruptedException {
        String title = "Appium";
        app.article().open();
        app.article().addToFavorits();
        app.article().createListOfFavorits("My list");
        app.article().close();
        app.article().openMyLists();
        app.article().openFavoritList("My list");
        String titleOfArticle = app.article().getTitleOfFirst();
        Assert.assertEquals(titleOfArticle, title, "Article Title Is " + titleOfArticle);
    }

    @Test
    public void deleteFromFavorites() {
        app.article().delete();

    }
}

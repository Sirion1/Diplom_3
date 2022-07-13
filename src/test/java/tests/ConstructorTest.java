package tests;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    MainPage mainPage;
    @Test
    @DisplayName("Проверка видимости раздела Булки")
    @Description("Проверка видимости раздела Булки на главной страницы при клике")
    public void constructorTabsBunsTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.chooseSauce();
        Assert.assertTrue(mainPage.isVisiblTabOfBun());
    }

    @Test
    @DisplayName("Проверка видимости раздела Соусы")
    @Description("Проверка видимости раздела Соусы на главной страницы при клике")
    public void constructorTabsSauceTest(){
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        Assert.assertTrue(mainPage.isVisiblTabOSauces());
    }

    @Test
    @DisplayName("Проверка видимости раздела Начинки")
    @Description("Проверка видимости раздела Начинки на главной страницы при клике")
    public void constructorTabsFillingTest(){
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        Assert.assertTrue(mainPage.isVisiblTabOfFilling());
    }
}



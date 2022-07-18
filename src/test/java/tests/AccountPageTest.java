package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import user.CreateUser;
import user.UserUITest;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class AccountPageTest {
    private UserUITest userUITest;
    private CreateUser createUser;
    private MainPage mainPage;
    private String accessToken;
    private LoginPage loginPage;
    private AccountPage accountPage;


    @Before
    public void setUp() {
        Configuration.browser = "Chrome";
        createUser = new CreateUser();
        userUITest = UserUITest.getRandom();
        ValidatableResponse createResponse = createUser.userRegistration(userUITest);
        accessToken = createResponse.extract().path("accessToken");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            createUser.delete(accessToken);
        }
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }


    @Test
    @DisplayName("Вход в личный кабинет")
    @Description("Вход в личный кабинет с корректными данными")
    public void loginAccountTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.loginBtnClick();
        loginPage = page(LoginPage.class);
        loginPage.clickEmailField()
                .enterEmail(userUITest.email)
                .clickPasswordField()
                .enterPassword(userUITest.password)
                .loginBtnClick();
        mainPage.userBtnWithoutLogClick();
        accountPage = page(AccountPage.class);
        assertTrue(accountPage.exitBtnVisible());
    }

    @Test
    @DisplayName("Переход на вкладку конструктор")
    @Description("Клик по вкладке  переносит на соответствующий раздел")
    public void clickTabUserAccountTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.loginBtnClick();
        loginPage = page(LoginPage.class);
        loginPage.clickEmailField()
                .enterEmail(userUITest.email)
                .clickPasswordField()
                .enterPassword(userUITest.password)
                .loginBtnClick();
        mainPage.userBtnWithLogClick();
        accountPage = page(AccountPage.class);
        accountPage.constructorBtnClick();
        assertTrue(mainPage.titlePageIsDisplayed());
    }

    @Test
    @DisplayName("Клик по лого в хедере страницы")
    @Description("Клик по лого в хедере страницы")
    public void accountPageLogoClickTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.loginBtnClick();
        loginPage = page(LoginPage.class);
        loginPage.clickEmailField()
                .enterEmail(userUITest.email)
                .clickPasswordField()
                .enterPassword(userUITest.password)
                .loginBtnClick();
        mainPage.userBtnWithLogClick();
        accountPage = page(AccountPage.class);
        accountPage.logoHeaderClick();
        assertTrue(mainPage.titlePageIsDisplayed());
    }

    @Test
    @DisplayName("Логаут")
    @Description("Выход из аккаунта")
    public void userLogoutTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.loginBtnClick();
        loginPage = page(LoginPage.class);
        loginPage.clickEmailField()
                .enterEmail(userUITest.email)
                .clickPasswordField()
                .enterPassword(userUITest.password)
                .loginBtnClick();
        mainPage.userBtnWithLogClick();
        accountPage = page(AccountPage.class);
        accountPage.exitBtnClick();
        assertTrue(loginPage.btnLoginHeaderVisible());
    }
}

package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import pages.RestorePage;
import user.CreateUser;
import user.UserUITest;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;



public class LoginTest {
    private UserUITest userUITest;
    private CreateUser createUser;
    private MainPage mainPage;
    private String accessToken;


    @Before
    public void setUp() {
        System.setProperty("selenide.browser", "Chrome");
        createUser = new CreateUser();
        userUITest = UserUITest.getRandom();
        ValidatableResponse createResponse = CreateUser.userRegistration(userUITest);
        accessToken = createResponse.extract().path("accessToken");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            CreateUser.delete(accessToken);
        }
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }


    @Test
    @DisplayName("Авторизация на сайте через кнопку 'Войти в аккаунт' ")
    @Description("Авторизация через 'Войти в аккаунт'")
    public void userAuthorizationTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.loginBtnClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickEmailField()
                .enterEmail(userUITest.email)
                .clickPasswordField()
                .enterPassword(userUITest.password)
                .loginBtnClick();
        boolean expected = true;
        boolean actual = mainPage.orderBtnDisplayed();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Авторизация на сайте через личный кабитне ")
    @Description("Авторизация через личный кабинет")
    public void userAuthorizationPersonalCabinetTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.loginBtnClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickEmailField()
                .enterEmail(userUITest.email)
                .clickPasswordField()
                .enterPassword(userUITest.password)
                .loginBtnClick();
        boolean expected = true;
        boolean actual = mainPage.orderBtnDisplayed();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Авторизация на сайте через кнопку в форме регистрации")
    @Description("Авторизация через кнопку в форме реги")
    public void userAuthorizationWithPersonalCabintetLoginBtnTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.loginBtnClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.registrationBtnClick();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.loginBtnClick();
        loginPage.clickEmailField()
                .enterEmail(userUITest.email)
                .clickPasswordField()
                .enterPassword(userUITest.password)
                .loginBtnClick();
        boolean expected = true;
        boolean actual = mainPage.orderBtnDisplayed();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Авторизация юзера через формы восстановления пароля")
    @Description("Авторизация юзера через формы восстановления пароля")
    public void userAuthorizationWithRecoveryPasswordFormTest() {
        mainPage = open(MainPage.getMainPageURL(), MainPage.class);
        mainPage.loginBtnClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.recoveryPasswordBtnClick();
        RestorePage restorePage = page(RestorePage.class);
        restorePage.loginBtnClick();
        loginPage.clickEmailField()
                .enterEmail(userUITest.email)
                .clickPasswordField()
                .enterPassword(userUITest.password)
                .loginBtnClick();
        boolean expected = true;
        boolean actual = mainPage.orderBtnDisplayed();
        assertEquals(expected, actual);
    }
}


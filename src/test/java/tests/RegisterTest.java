package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import user.CreateUser;
import user.UserDataForRegister;
import user.UserUITest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class RegisterTest {

        private UserUITest userUITest;
        private CreateUser createUser;
        private MainPage mainPage;
        private String accessToken;

        @Before
        public void setUp() {
            Configuration.browser = "Chrome";
            createUser = new CreateUser();
            userUITest = UserUITest.getRandom();
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
        @DisplayName("Позитивный тест регистрации юзера ")
        @Description("Тест регистрации с корректными данными")
        public void positiveRegistrationTest() {
            mainPage = open(MainPage.getMainPageURL(), MainPage.class);
            mainPage.userBtnWithoutLogClick();
            LoginPage loginPage = page(LoginPage.class);
            loginPage.registrationBtnClick();
            RegisterPage registerPage = page(RegisterPage.class);
            registerPage.clickNameField()
                    .setNameField(userUITest.name)
                    .clickEmailField()
                    .setEmailField(userUITest.email)
                    .clickPasswordField()
                    .setPasswordField(userUITest.password)
                    .registrationBtnClick();
            ValidatableResponse loginResponse = createUser.userLogIn(UserDataForRegister.builder().email(userUITest.email).password(userUITest.password).build());
            accessToken = loginResponse.extract().path("accessToken");
            assertThat( accessToken, notNullValue());
        }

        @Test
        @DisplayName("Негативный тест регистрации юзера ")
        @Description("Тест регистрации без пароля")
        public void negativeRegistrationTest() {
            MainPage mainPage = open(MainPage.getMainPageURL(), MainPage.class);
            mainPage.userBtnWithoutLogClick();
            LoginPage loginPage = page(LoginPage.class);
            loginPage.registrationBtnClick();
            RegisterPage registerPage = page(RegisterPage.class);
            registerPage.clickNameField()
                    .setNameField(userUITest.name)
                    .clickEmailField()
                    .setEmailField(userUITest.email)
                    .clickPasswordField()
                    .setPasswordField(RandomStringUtils.randomAlphabetic(5))
                    .registrationBtnClick();
            assertTrue(RegisterPage.incorrectPasswordMessageDisplayed());
        }
}


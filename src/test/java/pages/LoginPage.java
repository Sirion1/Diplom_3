package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    private String loginPageURL = "https://stellarburgers.nomoreparties.site/login";
    public String getLoginPageURL() {

        return loginPageURL;
    }

    @FindBy(how = How.XPATH, using = ".//input[@name ='name']")
    private SelenideElement emailFields;
    @FindBy(how = How.XPATH, using = ".//input[@name ='Пароль']")
    private SelenideElement passwordFields;
    @FindBy(how = How.XPATH, using = "//h2[text()=\"Вход\"]")
    private SelenideElement btnLoginHeader;
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement btnRegistration;
    @FindBy(how = How.XPATH, using = "(//input)")
    private ElementsCollection registrationFields;
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement loginBtn;
    @FindBy(how = How.XPATH, using = "//a[@href='/forgot-password']")
    private SelenideElement passwordRecoveryBtn;

    @Step("Проверить видимость логотипа")
    public boolean btnLoginHeaderVisible() {
        return btnLoginHeader.shouldBe(visible).isDisplayed();}

    @Step("Клик на кнопку регистрации")
    public void registrationBtnClick() {
        btnRegistration.click();
    }

    @Step("Клик по клавише входа")
    public void loginBtnClick() {
        loginBtn.click();
    }

    @Step("Клик на кнопку восстановления пароля")
    public void recoveryPasswordBtnClick() {
        passwordRecoveryBtn.click();
    }

    @Step
    public LoginPage clickEmailField() {emailFields.click();
        return this;}
   @Step
    public LoginPage enterEmail(String email) {emailFields.setValue(email);
        return this;}
    @Step
    public LoginPage clickPasswordField() {passwordFields.click();
        return this;}
    @Step
    public LoginPage enterPassword(String password) {passwordFields.setValue(password);
        return this;}
}

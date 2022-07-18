package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

         private String registrationPageURL = "https://stellarburgers.nomoreparties.site/register";


        @FindBy(how = How.XPATH, using = "(//fieldset//input)")
        private ElementsCollection registerFields;
        @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
        private SelenideElement registrationBtn;
        @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
        private static SelenideElement incorrectPasswordMessage;
        @FindBy(how = How.XPATH, using = "//a[@href='/account']")
        private SelenideElement loginBtn;
        @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
        private SelenideElement nameFields;
        @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
        private SelenideElement emailFields;
        @FindBy(how = How.XPATH, using = ".//input[@type='password']")
        private SelenideElement passwordFields;
        @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Зарегистрироваться')]")
        private SelenideElement registerBtn;

        @Step("Клик по кнопке Регистрация")
        public void registrationBtnClick() {
            registrationBtn.click();
        }

        @Step("Проверка сообщение о неверном пароле")
        public static boolean incorrectPasswordMessageDisplayed() {
            return incorrectPasswordMessage.isDisplayed();
        }

        @Step("Клик по кнопке 'Войти'")
        public void loginBtnClick() {
            loginBtn.click();
        }

        @Step
        public RegisterPage clickNameField() {
        nameFields.click();
        return this;}

        @Step
        public RegisterPage setNameField(String name) {
        nameFields.setValue(name);
        return this;}

        @Step
        public RegisterPage clickEmailField() {
        emailFields.click();
        return this;
        }
        @Step
        public RegisterPage setEmailField(String email) {
        emailFields.setValue(email);
        return this;}

        @Step
        public RegisterPage clickPasswordField() {
        passwordFields.click();
        return this;}

        @Step
        public RegisterPage setPasswordField(String password) {
        passwordFields.setValue(password);
        return this;}
}

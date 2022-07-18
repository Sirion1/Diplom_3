package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePage {

        @FindBy(how = How.XPATH, using = "//a[@href='/login']")
        private SelenideElement loginBtn;

        @Step("Клик по кнопке 'Войти'")
        public void loginBtnClick() {
            loginBtn.click();
        }
    }


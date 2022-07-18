package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;

public class AccountPage {

    private String accountPageURL = "https://stellarburgers.nomoreparties.site/account/profile";
    public String getAccountPageURL() {
        return accountPageURL;
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    private SelenideElement profileBtn;
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement constructorBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']/a")
    private SelenideElement logoHeader;
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement exitBtn;

    @Step("Клик по лого")
    public void logoHeaderClick() {
        logoHeader.click();
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void constructorBtnClick() {
        constructorBtn.click();
    }

    @Step("Клик по кнопке 'Выход'")
    public void exitBtnClick() {
        exitBtn.click();
    }

    @Step("Видимость кнопки 'Выход'")
    public boolean exitBtnVisible() {
            return exitBtn.shouldBe(visible).isDisplayed();
        }


}

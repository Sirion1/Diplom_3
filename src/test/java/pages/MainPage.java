package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private static String mainPageURL = "https://stellarburgers.nomoreparties.site/";

    public static String getMainPageURL() {
        return mainPageURL;
    }

    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement userlAccountBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoBlock;
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement loginBtn;
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement orderBtn;
    @FindBy(how = How.XPATH, using = "//nav/a[@class='AppHeader_header__link__3D_hX']")
    private SelenideElement accountBtn;
    @FindBy(how = How.XPATH, using = "(//span[@class='text text_type_main-default'])")
    private ElementsCollection ingredientList;
    @FindBy(how = How.XPATH, using = "(//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2)")
    private ElementsCollection ingredientMenuList;
    @FindBy(how = How.XPATH, using = ".//h1[contains(text(),'Соберите бургер')]")
    private SelenideElement titlePage;
    @FindBy(how = How.XPATH, using = ".//div[span[text()='Булки']]")
    private SelenideElement bunsType;
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsDetected;
    @FindBy(how = How.XPATH, using = ".//div[span[text()='Соусы']]")
    private SelenideElement saucesType;
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement saucesDetected;
    @FindBy(how = How.XPATH, using = ".//div[span[text()='Начинки']]")
    private SelenideElement fillingsType;
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingsDetector;
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private static SelenideElement tabButtonActive;

    public static boolean tabButtonActiveCorrect(String title) {
        return tabButtonActive.getText().contentEquals(title);
    }
    public LoginPage userBtnWithoutLogClick() {
        userlAccountBtn.click();
        return page(LoginPage.class);
    }

    public AccountPage userBtnWithLogClick() {
        userlAccountBtn.click();
        return page(AccountPage.class);
    }

    @Step("Клик по кнопке 'Войти'")
    public void loginBtnClick() {
        loginBtn.click();
    }

    @Step("Проверка кнопки 'Оформить заказ'на displayed")
    public boolean orderBtnDisplayed() {
        return orderBtn.shouldBe(visible).isDisplayed();
    }

    @Step("Ожидание видимости кнопки 'Оформить заказ'")
    public MainPage orderBtnVisible() {
        orderBtn.shouldBe(visible, Duration.ofSeconds(8));
        return this;
    }

    public boolean titlePageIsDisplayed() {
        return titlePage.shouldBe(visible).isDisplayed();
    }

    @Step("Выбрать вкладку соусы")
    public SelenideElement chooseSauce() {
        saucesType.click();
        return saucesType;
    }

    @Step("Выбрать вкладку начинки")
    public SelenideElement chooseFiling() {
        fillingsType.click();
        return fillingsType;
    }

}

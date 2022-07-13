package pages;

import com.codeborne.selenide.Condition;
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

    @Step("Проверка видимости кнопки переключения типа ингредиентов")
    public boolean ingredientTypeTabeVisible(int numberOfType) {
        return ingredientMenuList.get(numberOfType)
                .shouldBe(visible, Duration.ofSeconds(10)).is(visible);
    }

    @Step("Ожидание видимости переключателя таба ингредиентов и клик по вкладке")
    public void setIngredientMenuListClick(int numberOfElement) {
        ingredientList.get(numberOfElement)
                .shouldBe(visible, Duration.ofSeconds(8)).shouldBe(visible).click();
    }

    public boolean titlePageIsDisplayed() {
        return titlePage.shouldBe(visible).isDisplayed();
    }

    @Step("Выбрать вкладку булки")
    public SelenideElement chooseBun() {
        bunsType.click();
        return bunsType;
    }

    @Step("Найти вкладку булки")
    public SelenideElement getBun() {
        return bunsType;
    }

    @Step("Выбрать вкладку соусы")
    public SelenideElement chooseSauce() {
        saucesType.click();
        return saucesType;
    }

    @Step("Найти вкладку соусы")
    public SelenideElement getSauce() {
        return saucesType;
    }

    @Step("Выбрать вкладку начинки")
    public SelenideElement chooseFiling() {
        fillingsType.click();
        return fillingsType;
    }

    @Step("Проверка, что при клике на Булки появляются булки")
    public boolean isVisiblTabOfBun() {
        bunsType.click();
        bunsDetected.shouldBe(Condition.visible);
        return true;
    }

    @Step("Проверка, что при клике на Начинки появляются Начинки")
    public boolean isVisiblTabOfFilling() {
        fillingsType.click();
        fillingsDetector.shouldBe(Condition.visible);
        return true;
    }

    @Step ("Проверка, что при клике на Соусы появляются соусы")
    public boolean isVisiblTabOSauces() {
        saucesType.click();
        saucesDetected.shouldBe(Condition.visible);
        return true;
        }
    }

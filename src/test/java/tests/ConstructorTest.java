package tests;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import user.UserGetter;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ConstructorTest {
    private MainPage mainPage;
    UserGetter userGetter;
    int numberOfIngredient;

    public ConstructorTest(int numberOfIngredient) {
        this.numberOfIngredient = numberOfIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {0},
                {1},
                {2},
        };
    }
    @Before
    public void initializationTestData() {
        System.setProperty("selenide.browser", "Chrome");
        userGetter = new UserGetter();
        mainPage = page(MainPage.class);
        open(MainPage.getMainPageURL(), MainPage.class);
    }

    @Test
    @DisplayName("Конструктор бургеру")
    @Description("Клик по вкладкам  переносит на соответствующий раздел")
    public void isBurgerConstructorTubsLeadToIngredientSectionsTest() {
        if (numberOfIngredient == 0) {
            mainPage.setIngredientMenuListClick(1);
            mainPage.ingredientTypeTabeVisible(1);
        }
        mainPage.setIngredientMenuListClick(numberOfIngredient);
        boolean expected = true;
        boolean actual = mainPage.ingredientTypeTabeVisible(numberOfIngredient);
        assertEquals(expected, actual);
    }
}

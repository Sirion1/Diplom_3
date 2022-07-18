package user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.lang.Math.log;
import static user.RestAssureUser.getRestAssureUser;


public class CreateUser {

    static UserGetter.User newUser = new UserGetter.User();
    private static String accessToken;
    private static Response response;

    public static Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken() {
        accessToken = response.then().extract().path("accessToken");
    }

    @Step("Регистрация пользователя")
    public static ValidatableResponse userRegistration(UserUITest userUITest) {
        return given()
                .spec(getRestAssureUser())
                .body(userUITest)
                .when()
                .post("auth/register")
                .then();
    }

    @Step("Авторизация юзера с емейлом и паролем для теста регистрации")
    public static ValidatableResponse userLogIn (UserDataForRegister build) {
        return given()
                .spec(getRestAssureUser())
                .body(build)
                .when()
                .post("auth/login")
                .then();
    }

    @Step("Авторизация юзера с емейлом и паролем для теста регистрации")
    public static ValidatableResponse userLogInForTest(UserGetter build) {
        return given()
                .spec(getRestAssureUser())
                .body(build)
                .when()
                .post("auth/login")
                .then();
    }

    @Step("Удаление юзера")
    public static void delete(String accessToken) {
        if (getAccessToken() == null) return;
        given()
                .spec(getRestAssureUser())
                .headers("Authorization", CreateUser.accessToken)
                .when()
                .delete("auth/user")
                .then()
                .statusCode(202);
        System.out.println(getAccessToken());
    }
}
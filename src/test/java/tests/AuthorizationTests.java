package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static io.qameta.allure.Allure.step;

public class AuthorizationTests extends TestBase {

    LoginPage loginPage = new LoginPage();

    @DisplayName("Успешная авторизация с валидными данными")
    @Test
    void successfulLoginWithValidCredentialsTest() {
            step("Открыть страницу авторизации", () -> {
                loginPage.openLoginPage(1);
            });
            step("Вводим email", () -> {
                loginPage.enterEmail("pola228@list.ru");
            });
            step("Вводи пароль", () -> {
                loginPage.enterPassword("12345qwerty");
            });
            step("Нажать кнопку 'Войти'", () -> {
                loginPage.clickSubmitButton();
            });
            step("Проверить сообщение об успешной авторизации", () -> {
                loginPage.checkAlertMessage("Внутри лучше чем снаружи. Запоминаем прогресс и ведем к свету");
            });
    }

    @DisplayName("Авторизация с неверным паролем")
    @Test
    void loginWithIncorrectPasswordTest() {
    }

    @DisplayName("Авторизация с несуществующим email")
    @Test
    void loginWithNonExistentEmailTest() {
    }

}

package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;

import static io.qameta.allure.Allure.step;

public class UserAuthenticationTests extends TestBase {

    AuthenticationPage authenticationPage = new AuthenticationPage();

    @Test
    @DisplayName("Успешная авторизация с валидными данными")
    void successfulLoginWithValidCredentialsTest() {
        step("Открыть страницу авторизации", () -> {
            authenticationPage.openLoginPage(1);
        });
        step("Вводим email", () -> {
            authenticationPage.enterEmail("pola228@list.ru");
        });
        step("Вводи пароль", () -> {
            authenticationPage.enterPassword("12345qwerty");
        });
        step("Нажать кнопку 'Войти'", () -> {
            authenticationPage.clickSubmitButton();
        });
        step("Проверить сообщение об успешной авторизации", () -> {
            authenticationPage.checkAlertMessage("Внутри лучше чем снаружи. Запоминаем прогресс и ведем к свету");
        });
    }

    @Test
    @DisplayName("Авторизация с неверным паролем")
    void loginWithIncorrectPasswordTest() {
        step("Открыть страницу авторизации", () -> {
            authenticationPage.openLoginPage(1);
        });
        step("Вводим email", () -> {
            authenticationPage.enterEmail("pola228@list.ru");
        });
        step("Вводи пароль", () -> {
            authenticationPage.enterPassword("wrong_password");
        });
        step("Нажать кнопку 'Войти'", () -> {
            authenticationPage.clickSubmitButton();
        });
        step("Проверить, что мы остаемся на странице авторизации", () -> {
            authenticationPage.checkUrlCorrection("https://code-basics.com/ru/session/new");
        });
    }

    @Test
    @DisplayName("Переход на страницу восстановления пароля")
    void navigateToPasswordRecoveryPage() {
        step("Открыть страницу авторизации", () -> {
            authenticationPage.openLoginPage(1);
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickRecoveryLink();
        });
        step("Проверить, что оказались на странице восстановления пароля", () -> {
            authenticationPage.checkRecoveryMessage("Восстановление пароля");
        });
    }

    @Test
    @DisplayName("Успешное восстановление пароля с валидным email")
    void recoverPasswordWithValidEmail() {
        step("Открыть страницу авторизации", () -> {
            authenticationPage.openLoginPage(1);
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickRecoveryLink();
        });
        step("Вводим email", () -> {
            authenticationPage.enterRecoveryEmail("pola228@list.ru");
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickSubmitButton();
        });
        step("Проверяем, что отображается сообщение об отправке письма", () -> {
            authenticationPage.checkAlertMessage("Мы отправили вам письмо с инструкциями по восстановлению пароля");
        });
    }

    @Test
    @DisplayName("Восстановление пароля с невалидным email")
    void recoverPasswordWithInvalidEmail() {
        step("Открыть страницу авторизации", () -> {
            authenticationPage.openLoginPage(1);
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickRecoveryLink();
        });
        step("Вводим невалидный email", () -> {
            authenticationPage.enterRecoveryEmail("invalid_email");
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickSubmitButton();
        });
        step("Проверяем, что отображается сообщение о некорректном вводе email", () -> {
            authenticationPage.checkAlertMessage("В форме есть ошибки");
        });
    }

    @Test
    @DisplayName("Восстановление пароля с несуществующим email")
    void recoverPasswordWithNonExistentEmail() {
        step("Открыть страницу авторизации", () -> {
            authenticationPage.openLoginPage(1);
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickRecoveryLink();
        });
        step("Вводим невалидный email", () -> {
            authenticationPage.enterRecoveryEmail("polaloveeeeeee@list.ru");
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickSubmitButton();
        });
        step("Проверяем, что отображается сообщение о некорректном вводе email", () -> {
            authenticationPage.checkAlertMessage("В форме есть ошибки");
        });
    }

    @Test
    @DisplayName("Восстановление пароля с пустым полем email")
    void recoverPasswordWithEmptyEmail() {
        step("Открыть страницу авторизации", () -> {
            authenticationPage.openLoginPage(1);
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickRecoveryLink();
        });
        step("Вводим невалидный email", () -> {
            authenticationPage.enterRecoveryEmail("");
        });
        step("Нажимаем на кнопку 'Восстановить'", () -> {
            authenticationPage.clickSubmitButton();
        });
        step("Проверяем, что отображается сообщение о некорректном вводе email", () -> {
            authenticationPage.checkAlertMessage("В форме есть ошибки");
        });
    }
}
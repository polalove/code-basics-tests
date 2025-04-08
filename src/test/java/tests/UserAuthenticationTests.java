package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;

import static data.Credentials.LOGIN;
import static data.Credentials.PASSWORD;

@Tag("codebasics-auth-tests")
@DisplayName("Тесты на авторизацию")
public class UserAuthenticationTests extends TestBase {

    AuthenticationPage authenticationPage = new AuthenticationPage();

    @Test
    @DisplayName("Успешная авторизация с валидными данными")
    void successfulLoginWithValidCredentialsTest() {
        authenticationPage.openLoginPage(0);
        authenticationPage.enterEmail(LOGIN);
        authenticationPage.enterPassword(PASSWORD);
        authenticationPage.clickSubmitButton();
        authenticationPage.checkAlertMessage("Внутри лучше чем снаружи. Запоминаем прогресс и ведем к свету");
    }

    @Test
    @DisplayName("Авторизация с неверным паролем")
    void loginWithIncorrectPasswordTest() {
        authenticationPage.openLoginPage(0);
        authenticationPage.enterEmail(LOGIN);
        authenticationPage.enterPassword(TestData.getRandomWrongPassword());
        authenticationPage.clickSubmitButton();
        authenticationPage.checkUrlCorrection("https://code-basics.com/ru/session/new");
    }

    @Test
    @DisplayName("Переход на страницу восстановления пароля")
    void navigateToPasswordRecoveryPageTest() {
        authenticationPage.openLoginPage(0);
        authenticationPage.clickRecoveryLink();
        authenticationPage.checkRecoveryMessage("Восстановление пароля");
    }

    @Test
    @DisplayName("Успешное восстановление пароля с валидным email")
    void recoverPasswordWithValidEmailTest() {
        authenticationPage.openLoginPage(0);
        authenticationPage.clickRecoveryLink();
        authenticationPage.enterRecoveryEmail(LOGIN);
        authenticationPage.clickSubmitButton();
        authenticationPage.checkAlertMessage("Мы отправили вам письмо с инструкциями по восстановлению пароля");
    }

    @Test
    @DisplayName("Восстановление пароля с невалидным email")
    void recoverPasswordWithInvalidEmailTest() {
        authenticationPage.openLoginPage(0);
        authenticationPage.clickRecoveryLink();
        authenticationPage.enterRecoveryEmail(TestData.getRandomInvalidEmail());
        authenticationPage.clickSubmitButton();
        authenticationPage.checkAlertMessage("В форме есть ошибки");
    }

    @Test
    @DisplayName("Восстановление пароля с несуществующим email")
    void recoverPasswordWithNonExistentEmailTest() {
        authenticationPage.openLoginPage(0);
        authenticationPage.clickRecoveryLink();
        authenticationPage.enterRecoveryEmail(TestData.getRandomNonExistentEmail());
        authenticationPage.clickSubmitButton();
        authenticationPage.checkAlertMessage("В форме есть ошибки");
    }

    @Test
    @DisplayName("Восстановление пароля с пустым полем email")
    void recoverPasswordWithEmptyEmailTest() {
        authenticationPage.openLoginPage(0);
        authenticationPage.clickRecoveryLink();
        authenticationPage.enterRecoveryEmail("");
        authenticationPage.clickSubmitButton();
        authenticationPage.checkAlertMessage("В форме есть ошибки");
    }
}
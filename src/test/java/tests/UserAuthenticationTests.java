package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthenticationPage;

import static data.Credentials.LOGIN;
import static data.Credentials.PASSWORD;

@Tag("codebasics-tests")
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


}
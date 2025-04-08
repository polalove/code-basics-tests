package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AuthenticationPage;

import java.util.stream.Stream;

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

    @ParameterizedTest(name = "Авторизация с неверным паролем: {0}")
    @MethodSource("provideWrongPasswords")
    @DisplayName("Авторизация с неверными паролями")
    void loginWithIncorrectPasswordTest(String password) {
        authenticationPage.openLoginPage(0);
        authenticationPage.enterEmail(LOGIN);
        authenticationPage.enterPassword(password);
        authenticationPage.clickSubmitButton();
        authenticationPage.checkUrlCorrection("https://code-basics.com/ru/session/new");
    }

    private static Stream<Arguments> provideWrongPasswords() {
        return Stream.of(
                Arguments.of(TestData.getRandomWrongPassword()),
                Arguments.of(TestData.getRandomWrongPassword()),
                Arguments.of("invalid_password_123")
        );
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

    @ParameterizedTest(name = "Восстановление пароля с невалидным email: {0}")
    @ValueSource(strings = {
            "invalid",
            "test@",
            "@domain.com",
            "noatsign"
    })
    @DisplayName("Восстановление пароля с невалидными email")
    void recoverPasswordWithInvalidEmailTest(String email) {
        authenticationPage.openLoginPage(0);
        authenticationPage.clickRecoveryLink();
        authenticationPage.enterRecoveryEmail(email);
        authenticationPage.clickSubmitButton();
        authenticationPage.checkAlertMessage("В форме есть ошибки");
    }

    @ParameterizedTest(name = "Восстановление пароля с несуществующим email: {0}")
    @MethodSource("provideNonExistentEmails")
    @DisplayName("Восстановление пароля с несуществующими email")
    void recoverPasswordWithNonExistentEmailTest(String email) {
        authenticationPage.openLoginPage(0);
        authenticationPage.clickRecoveryLink();
        authenticationPage.enterRecoveryEmail(email);
        authenticationPage.clickSubmitButton();
        authenticationPage.checkAlertMessage("В форме есть ошибки");
    }

    private static Stream<Arguments> provideNonExistentEmails() {
        return Stream.of(
                Arguments.of(TestData.getRandomNonExistentEmail()),
                Arguments.of("nonexistent1@example.com"),
                Arguments.of("notregistered@test.org")
        );
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
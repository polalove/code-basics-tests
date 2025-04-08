package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AuthenticationPage;

import java.util.stream.Stream;

import static data.Credentials.LOGIN;

@Tag("codebasics-tests")
@Tag("parametrized")
@DisplayName("Параметризованные тесты авторизации")
public class UserAuthenticationParametrizedNegativeTests extends TestBase {

    AuthenticationPage authenticationPage = new AuthenticationPage();

    @ParameterizedTest(name = "Авторизация с неверным паролем: {0}")
    @MethodSource("provideWrongPasswords")
    @DisplayName("Негативные тесты: авторизация с неверными паролями. ")
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
                Arguments.of("invalid_password_123!"),
                Arguments.of("short"),
                Arguments.of("1234567890"),
                Arguments.of("no_special_chars")
        );
    }

    @ParameterizedTest(name = "Восстановление пароля с невалидным email: {0}")
    @ValueSource(strings = {
            "invalid",
            "test@",
            "@domain.com",
            "noatsign",
            "space in@email.com"
    })
    @DisplayName("Негативные тесты: невалидные email при восстановлении. ")
    void recoverPasswordWithInvalidEmailTest(String email) {
        authenticationPage.openLoginPage(0);
        authenticationPage.clickRecoveryLink();
        authenticationPage.enterRecoveryEmail(email);
        authenticationPage.clickSubmitButton();
        authenticationPage.checkAlertMessage("В форме есть ошибки");
    }

    @ParameterizedTest(name = "Восстановление пароля с несуществующим email: {0}")
    @MethodSource("provideNonExistentEmails")
    @DisplayName("Негативные тесты: несуществующие email при восстановлении. ")
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
                Arguments.of("nonexistent_user@example.org"),
                Arguments.of("unknown_${System.currentTimeMillis()}@test.com"),
                Arguments.of("deleted_account@mail.ru")
        );
    }
}
package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AuthenticationPage {

    private final ElementsCollection loginLink = $$(".link-body-emphasis.nav-link");
    private final SelenideElement emailInput = $("#user_sign_in_form_email");
    private final SelenideElement passwordInput = $("#user_sign_in_form_password");
    private final SelenideElement submitButton = $("button[type='submit']");
    private final SelenideElement alertMessage = $("div[role='alert']");
    private final SelenideElement passwordLink = $("a[href='/ru/remind_password/new']");
    private final SelenideElement recoveryPasswordHeader = $("h1");
    private final SelenideElement recoveryEmailInput = $("#remind_password_form_email");


    @Step("Открываем страницу авторизации")
    public void openLoginPage(int index) {
        open("/ru");
        loginLink.get(index).click();
    }

    @Step("Вводим email")
    public void enterEmail(String email) {
        emailInput.setValue(email);
    }

    @Step("Вводим пароль")
    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Нажимаем кнопку 'Войти'")
    public void clickSubmitButton() {
        submitButton.click();
        sleep(200);
    }

    @Step("Проверяем сообщение")
    public void checkAlertMessage(String expectedText) {
        alertMessage
                .shouldBe(visible)
                .shouldHave(text(expectedText));
    }

    @Step("Проверяем URL")
    public void checkUrlCorrection(String url) {
        webdriver().shouldHave(url(url));
    }

    @Step("Нажимаем 'Восстановить пароль'")
    public void clickRecoveryLink() {
        passwordLink.click();
    }

    @Step("Проверяем заголовок")
    public void checkRecoveryMessage(String text) {
        recoveryPasswordHeader.shouldHave(text(text));
    }

    @Step("Вводим email для восстановления")
    public void enterRecoveryEmail(String email) {
        recoveryEmailInput.setValue(email);
    }
}
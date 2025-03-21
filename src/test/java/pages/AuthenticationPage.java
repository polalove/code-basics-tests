package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AuthenticationPage {

    // Локаторы элементов страницы
    private final ElementsCollection loginLink = $$(".link-body-emphasis.nav-link");
    private final SelenideElement emailInput = $("#user_sign_in_form_email");
    private final SelenideElement passwordInput = $("#user_sign_in_form_password");
    private final SelenideElement submitButton = $("button[type='submit']");
    private final SelenideElement alertMessage = $("div[role='alert']");
    private final SelenideElement passwordLink = $("a[href='/ru/remind_password/new']");
    private final SelenideElement recoveryPasswordHeader = $("h1");
    private final SelenideElement recoveryEmailInput = $("#remind_password_form_email");

    // Метод для перехода на страницу авторизации
    public void openLoginPage(int index) {
        open("/ru");
        loginLink.get(index).click();
    }

    // Метод для ввода email
    public void enterEmail(String email) {
        emailInput.setValue(email);
    }

    // Метод для ввода пароля
    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    // Метод для нажатия кнопки "Войти"
    public void clickSubmitButton() {
        submitButton.click();
    }

    // Метод для проверки сообщения об успешной авторизации
    public void checkAlertMessage(String expectedText) {
        alertMessage
                .shouldBe(visible)
                .shouldHave(text(expectedText));
    }

    public void checkUrlCorrection(String url) {
        webdriver().shouldHave(url(url));
    }

    public void clickRecoveryLink() {
        passwordLink.click();
    }

    public void checkRecoveryMessage(String text) {
        recoveryPasswordHeader.shouldHave(text(text));
    }

    public void enterRecoveryEmail(String email) {
        recoveryEmailInput.setValue(email);
    }
}
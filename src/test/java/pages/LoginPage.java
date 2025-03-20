package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    // Локаторы элементов страницы
    private ElementsCollection loginLink = $$(".link-body-emphasis.nav-link");
    private SelenideElement emailInput = $("#user_sign_in_form_email");
    private SelenideElement passwordInput = $("#user_sign_in_form_password");
    private SelenideElement submitButton = $("button[type='submit']");
    private SelenideElement alertMessage = $("div[role='alert']");

    // Метод для перехода на страницу авторизации
    public LoginPage openLoginPage(int index) {
        open("/");
        loginLink.get(index).click();
        return this;
    }

    // Метод для ввода email
    public LoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    // Метод для ввода пароля
    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    // Метод для нажатия кнопки "Войти"
    public LoginPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    // Метод для проверки сообщения об успешной авторизации
    public void checkAlertMessage(String expectedText) {
        alertMessage
                .shouldBe(visible)
                .shouldHave(text(expectedText));
    }
}
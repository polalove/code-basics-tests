package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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


    public void openMainPage() {
        open("/ru");
    }

    public void openLoginPage(int index) {
        loginLink.get(index).click();
    }


    public void enterEmail(String email) {
        emailInput.setValue(email);
    }

    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
        sleep(200);
    }

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
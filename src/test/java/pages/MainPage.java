package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final ElementsCollection dropDownLanguageMenu = $$("a.dropdown-toggle");
    private final SelenideElement englishLanguageButton = $("a[href='/ru/locale/switch?new_locale=en']");
    private final SelenideElement coursesTitle = $("#courses");
    private final SelenideElement primaryButton = $("a.btn-primary");
    private final ElementsCollection javaButtonCourses = $$(".card-title");
    private final SelenideElement javaStartButton = $("a[href='/ru/languages/java/lessons/hello-world']");
    private final SelenideElement simulatorTitle = $("h1");


    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("/ru");
    }

    @Step("Нажимаем на меню смены языка")
    public void clickLanguageDropDownMenu() {
        dropDownLanguageMenu.get(1).click();
    }

    @Step("Выбираем английский язык")
    public void clickEnglishLanguageButton() {
        englishLanguageButton.click();
    }

    @Step("Проверяем, что язык изменился на английский")
    public void languageChangeCheck(String text) {
        coursesTitle.shouldHave(text(text));
    }

    @Step("Нажимаем на кнопку 'Попробовать'")
    public void primaryButtonClick() {
        primaryButton.click();
    }

    @Step("Выбираем курс Java")
    public void clickJavaCourses(int index) {
        javaButtonCourses.get(0).click();
    }

    @Step("Нажимаем на кнопку 'Начать обучение'")
    public void clickStartButton() {
        javaStartButton.click();
    }

    @Step("Проверяем заголовок")
    public void checkTitleTextOnSimulator(String text) {
        simulatorTitle.shouldHave(text(text));
    }
}

package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("codebasics-tests")
@DisplayName("Тесты на главном экране")
public class MainPageContentTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка успешной смены языка")
    void successfulLanguageChangeTest() {
        mainPage.openMainPage();
        mainPage.clickLanguageDropDownMenu();
        mainPage.clickEnglishLanguageButton();
        mainPage.languageChangeCheck("Courses");
    }

    @Test
    @DisplayName("Проверка открытия тренажера с курсами по Java")
    void openJavaCourseTrainerTest() {
        mainPage.openMainPage();
        mainPage.primaryButtonClick();
        mainPage.clickJavaCourses(0);
        mainPage.clickStartButton();
        mainPage.checkTitleTextOnSimulator("Java: Привет, Мир!");
    }

}
# Проект по автоматизации тестирования для веб-приложения [CODE BASICS](https://code-basics.com/ru)

> **CODE BASICS** — Это полностью бесплатная платформа для изучения основ программирования с нуля. Code Basics был создан разработчиками и сообществом Хекслет для того, чтобы любой желающий мог попробовать себя в программировании и заложить правильный фундамент для новой профессии, основанный не на запоминании специфики, а на понимании системы в целом.

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#alluretestops">Интеграция с Allure TestOps</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/AllureReport.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
- ✓ *Успешная авторизация с валидными данными.*
- ✓ *Авторизация с неверным паролем.*
- ✓ *Переход на страницу восстановления пароля.*
- ✓ *Успешное восстановление пароля с валидным email.*
- ✓ *Восстановление пароля с невалидным email.*
- ✓ *Восстановление пароля с несуществующим email.*
- ✓ *Восстановление пароля с пустым полем email.*
- ✓ *Проверка успешной смены языка.*
- ✓ *Проверка открытия тренажера с курсами по Java.*



____
<a id="jenkins"></a>
## <img alt="Jenkins" height="20" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/code-basics-tests/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/code-basics-tests/"><img src="images/screenshots/JenkinsBuild.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**
 
- *ENVIRONMENT (окружение в котором будем запускать тесты, по умолчанию PROD)*
- *COMMENT (комментарий, который отобразиться в Telegram отчете)*
- *BROWSER (браузер, по умолчанию chrome)*
- *REMOTE_URL (адрес хоста для удалённого запуска тестов)*
- *BROWSER_VERSION (версия браузера)*
- *BROWSER_SIZE (размер окна браузера)*

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean uiTests
```
```bash  
gradle clean test
```

***Удалённый запуск через Jenkins:***
```bash  
clean 
uiTests 
"-DbrowserType=${BROWSER}" 
"-DbrowserSize=${BROWSER_SIZE}" 
"-DremoteUrl=${REMOTE_URL}"
"-Dlogin=${LOGIN}"
"-Dpassword=${PASSWORD}"
```
___
<a id="allure"></a>
## <img alt="Allure" height="20" src="images/logo/AllureReport.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/code-basics-tests/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshots/AllureMainPage.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screenshots/AllureTestCases.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screenshots/AllureGraphic.png" width="850">

</p>

### Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4707/test-cases?treeId=0)

<p align="center">
  <img title="Allure Graphics" src="images/screenshots/AllureTestOps.png" width="850">
</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="20" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshots/TelegramNotification.png" width="550">  
</p>

____

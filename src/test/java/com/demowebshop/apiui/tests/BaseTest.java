package com.demowebshop.apiui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demowebshop.apiui.config.SettingTest;
import com.demowebshop.apiui.config.app.App;
import com.demowebshop.apiui.tools.Attacher;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
       new SettingTest().configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("");
    }

    @AfterEach
    void addAttachments() {
        Attacher.screenshotAs("Last screenshot");
        Attacher.pageSource();
        Attacher.browserConsoleLogs();
        Attacher.addVideo();

        closeWebDriver();
    }

    /**
     * Достать куки авторизации из полученного ответа.
     */
    protected Cookie getLoginCookie(ValidatableResponse loginResponse) {
        String cookie = loginResponse
            .extract()
            .cookie("NOPCOMMERCE.AUTH");

        return new Cookie("NOPCOMMERCE.AUTH", cookie);
    }

    /**
     * Добавить куки в браузер селенида.
     */
    protected void setCookieToWebDriver(Cookie cookie){
        getWebDriver().manage().addCookie(cookie);
    }
}

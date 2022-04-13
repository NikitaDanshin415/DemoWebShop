package com.demowebshop.apiui.tools.ui.helpers;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demowebshop.apiui.config.SettingTest;
import com.demowebshop.apiui.tools.Attacher;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
       new SettingTest().configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attacher.screenshotAs("Last screenshot");
        Attacher.pageSource();
        Attacher.browserConsoleLogs();
        Attacher.addVideo();

        closeWebDriver();
    }

}

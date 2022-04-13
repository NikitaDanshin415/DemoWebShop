package com.demowebshop.apiui.tools.ui.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demowebshop.apiui.config.app.App;
import com.demowebshop.apiui.config.webdriver.WebDriverProvider;
import com.demowebshop.apiui.tools.Attacher;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = WebDriverProvider.config.getBrowser();
        Configuration.baseUrl = App.config.getWebUrl();
        RestAssured.basePath = App.config.getApiUrl();

        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (WebDriverProvider.config.isRemote()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = WebDriverProvider.config.getRemoteDriverUrl();
        }
    }

    @AfterEach
    void addAttachments() {
        Attacher.screenshotAs("Screenshot");
        Attacher.pageSource();
        Attacher.browserConsoleLogs();
        Attacher.addVideo();
        closeWebDriver();
    }

}

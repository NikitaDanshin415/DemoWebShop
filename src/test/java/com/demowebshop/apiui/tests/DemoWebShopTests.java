package com.demowebshop.apiui.tests;

import com.demowebshop.apiui.config.app.App;
import com.demowebshop.apiui.tools.ui.helpers.BaseTest;
import com.demowebshop.apiui.tools.ui.pageobject.HomePage;
import com.demowebshop.apiui.tools.ui.pageobject.LoginPage;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;

public class DemoWebShopTests extends BaseTest {

    @Test()
    void addProductToFolderTest() {

        step("Авторизация", () -> {
            new HomePage()
                .clickLogin();

            new LoginPage()
                .fillEmail(App.config.getLogin())
                .fillPassword(App.config.getPassword())
                .clickLogin();

            new HomePage()
                .userEmailIs(App.config.getLogin());
        });

        step("Открыть раздел с книгами", () -> {

        });

        step("Добавить книгу в корзину через API", () -> {

        });

        step("Проверить, что книга отображается в корзине", () -> {

        });

        step("Удалить книгу из корзины", () -> {

        });
    }
}

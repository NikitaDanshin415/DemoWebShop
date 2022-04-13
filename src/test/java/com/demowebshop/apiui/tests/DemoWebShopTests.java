package com.demowebshop.apiui.tests;

import com.demowebshop.apiui.tools.ui.helpers.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class DemoWebShopTests extends BaseTest {

    @Test()
    void addProductToFolderTest(){
        open("");
        sleep(5000);
    }
}

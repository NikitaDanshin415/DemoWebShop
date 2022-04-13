package com.demowebshop.apiui.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:config/app.properties",
    "classpath:config/remote.properties"
})
public interface AppConfig extends Config {

    @Key("webUrl")
    String getWebUrl();

    @Key("apiUrl")
    String getApiUrl();

    @Key("login")
    @DefaultValue("test@test.test12344.com")
    String getLogin();

    @Key("password")
    @DefaultValue("test1234")
    String getPassword();
}

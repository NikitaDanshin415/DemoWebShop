package com.demowebshop.apiui.config.app;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:config/appLocal.properties",
    "classpath:config/appRemote.properties"
})
public interface AppConfig extends Config {

    @Key("webUrl")
    String getWebUrl();

    @Key("apiUrl")
    String getApiUrl();

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();
}

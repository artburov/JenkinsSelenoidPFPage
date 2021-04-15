package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/driver.properties",
        "classpath:config/page.properties"})
public interface DriverConfig extends Config {
    @Key("remote.web.user")
    String remoteWebUser();

    @Key("remote.web.password")
    String remoteWebPassword();

    @Key("modal.title")
    String modalTitle();
}

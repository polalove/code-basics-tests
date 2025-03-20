package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:config/driver.properties"})
public interface DriverConfig extends Config {
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserType")
    @DefaultValue("chrome")
    String browserType();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();
}

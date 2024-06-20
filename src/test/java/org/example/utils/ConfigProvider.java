package org.example.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String SECOND_URL = readConfig().getString("secondUrl");
    Integer AGE = readConfig().getInt("age");
    String ADMIN_LOGIN = readConfig().getString("usersParams.admin.login");
    String ADMIN_PASSWORD = readConfig().getString("usersParams.admin.password");
    Boolean IS_ADMIN_ADMIN = readConfig().getBoolean("usersParams.admin.isAdmin");
    String DEMO_PASSWORD = readConfig().getString("usersParams.demo.password");
    String DEMO_LOGIN = readConfig().getString("usersParams.demo.login");
    Boolean IS_DEMO_ADMIN = readConfig().getBoolean("usersParams.demo.isAdmin");

}

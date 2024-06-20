package org.example.utils;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class PropertiesTest {

    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        String usernameFromProperties = System.getProperty("username");
        System.out.println(usernameFromProperties);

        assertEquals("LastShinigami", usernameFromProperties);
    }

    @Test
    public void readFromConf() {
        String urlFromConf = ConfigProvider.URL;
        System.out.println(urlFromConf);

        assertEquals("https://google.com/", urlFromConf);
    }
}

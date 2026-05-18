package testUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties properties = new Properties();

    static {

        try {

            String configPath = System.getProperty("user.dir")
                    + "/src/test/resources/config/config.properties";

            FileInputStream fis = new FileInputStream(configPath);

            properties.load(fis);

            System.out.println("CONFIG FILE LOADED");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}
package utils;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public ConfigReader() {
        if (properties == null) {
            loadProperties();
        }
    }

    private void loadProperties() {
        properties = new Properties();

        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String getBrowser(){
        return System.getProperty("browser", properties.getProperty("browser"));
    }

    public String getExecution(){
        return System.getProperty("execution", properties.getProperty("execution"));
    }

    public String getRemoteUrl(){
        return System.getProperty("remote.url", properties.getProperty("remote.url"));
    }

    public String getUrl(){
        return properties.getProperty("url");
    }
}
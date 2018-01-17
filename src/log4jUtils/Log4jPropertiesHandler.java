package log4jUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Log4jPropertiesHandler {
    private static volatile Log4jPropertiesHandler instance = null;
    public static Log4jPropertiesHandler instance()
    {
        if (null == instance)
        {
            synchronized (Log4jPropertiesHandler.class) {
                if (null == instance)
                {
                    instance = new Log4jPropertiesHandler();
                }
            }
        }
        return instance;
    }
    private Properties log4jProperties = null;
    private String log4jPropertyFilePath = "./log4j.properties";//properties.getPropertyConfig("path.log4j.config");
    private String log4jLogsPath = "./testng_output/html/logs/";//properties.getPropertyConfig("path.log4j.logs");

    public boolean log4jPropertiesWasLoaded() {
        boolean wasLoaded = true;
        if (log4jProperties == null) {
            wasLoaded = false;
        }
        return wasLoaded;
    }

    public Properties getLog4jProperties() {
        if (log4jProperties == null) {
            log4jProperties = loadLog4jPropertiesFrom(log4jPropertyFilePath);
        }
        return log4jProperties;
    }
    public void setPropertyConfigurator() {
        log4jProperties = loadLog4jPropertiesFrom(log4jPropertyFilePath);
        PropertyConfigurator.configure(log4jPropertyFilePath);
    }
    public void swithLogFileName(String fileName) {
        log4jProperties = getLog4jProperties();
        //log4jProperties.setProperty("log4j.rootLogger","DEBUG, FILE");
        log4jProperties.setProperty("log4j.appender.tcFileLog.File", log4jLogsPath + fileName + ".log");
        LogManager.resetConfiguration();
        PropertyConfigurator.configure(log4jProperties);
    }
    private Properties loadLog4jPropertiesFrom(String log4JPropertyFilePath) {
        Properties log4jPropertiesResult = new Properties();
        try {
            //InputStream configStream = getClass().getResourceAsStream("/log4j.properties");
            FileInputStream configStream = new FileInputStream(log4JPropertyFilePath);
            log4jPropertiesResult.load(configStream);
            configStream.close();
        } catch(IOException e) {
            System.out.println("Error: Cannot laod configuration file ");
        }
        return log4jPropertiesResult;
    }
}


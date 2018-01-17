package log4jUtils;

import org.apache.log4j.Logger;

public class Log {
    public static Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
        if (!(Log4jPropertiesHandler.instance().log4jPropertiesWasLoaded())) {
            Log4jPropertiesHandler.instance().setPropertyConfigurator();
        }
    }
}
package com.sjsu.cmpe281.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 
 * @author <a href="Bhargav@leantaas.com">Bhargav</a>
 */
public class LoggerUtil {
   
    private static FileHandler logTxtHandler = null;

    /**
     * This method used to initialize logger
     */
    public static void intilizeLogger() {
        try {
            // Create an appending file handler
            boolean append = true;
            logTxtHandler = new FileHandler("FlexHallMarkAuto.log", append);
            logTxtHandler.setFormatter(new SimpleFormatter());
            logTxtHandler.setLevel(Level.FINE);

            // Add to the desired logger
            Logger logger = Logger.getLogger("com.leantaas.flexhallmarkauto");
            logger.addHandler(logTxtHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method used to close the logger
     */
    public static void closeLogger() {

        if (logTxtHandler != null)
            logTxtHandler.close();
    }

}

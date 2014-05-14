package com.sjsu.cmpe281.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

import com.sjsu.cmpe281.constants.PizzaStoreConstants;

/**
 * 
 * @author <a href="Bhargav@leantaas.com">Bhargav</a>
 */
public class PropertyLoader {
    
    private static PropertyLoader propertyLoaderObj = null;

    private static Logger         logger            = Logger.getLogger(PropertyLoader.class.getName());

    private PropertyLoader() {

    }

    public synchronized Properties createConfigFileHook() {
        Properties prop = null;
        URL url = null;
        try {
            prop = new Properties();
//            url = ClassLoader.getSystemResource(PizzaStoreConstants.PROPERTY_FILE);
//            prop.load(url.openStream());
//            FileInputStream in = new   FileInputStream(PizzaStoreConstants.PROPERTY_FILE);
            prop.load(this.getClass().getResourceAsStream(PizzaStoreConstants.PROPERTY_FILE));
        } catch (IOException e) {
            logger.severe("Property file was not loaded " + e.getMessage());
            e.printStackTrace();
        }
        return prop;
    }

    public static synchronized PropertyLoader createPropertyLoaderObj() {

        if (propertyLoaderObj == null)
            propertyLoaderObj = new PropertyLoader();

        return propertyLoaderObj;
    }
    
}

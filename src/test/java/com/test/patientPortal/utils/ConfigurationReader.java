package com.test.patientPortal.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationReader {

    private static Properties configFile;

    static {
        try {

            FileInputStream fileInputStream = new FileInputStream("src\\test\\resources\\Configuration.properties");
            //initialize properties object
            configFile = new Properties();
            //load configuration.properties file
            configFile.load(fileInputStream);
            //close input stream
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }

}

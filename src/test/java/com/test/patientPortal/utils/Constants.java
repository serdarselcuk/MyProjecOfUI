package com.test.patientPortal.utils;

public class Constants {

    public final static String UI_URL = Decoder.decodes(ConfigurationReader.getProperty("UI_url")),
            USER_NAME = Decoder.decodes(ConfigurationReader.getProperty("userName")),
            PASSWORD = Decoder.decodes(ConfigurationReader.getProperty("password")),
            BROWSER = (ConfigurationReader.getProperty("browser"));


}

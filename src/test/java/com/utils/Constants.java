package com.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public final static String
            SIGN_IN_URL = Decoder.decodes(ConfigurationReader.getProperty("UI_url")),
            USER_NAME = Decoder.decodes(ConfigurationReader.getProperty("userName")),
            PASSWORD = Decoder.decodes(ConfigurationReader.getProperty("password")),
            BROWSER = ConfigurationReader.getProperty("browser"),
            HOME_PAGE_URL = "https://northwellhealth.followmyhealth.com/patientaccess#/Home",
            MY_HEALTHSUMMARY_PAGE_URL = "https://northwellhealth.followmyhealth.com/patientaccess#/MyHealth/Summary",
            MESSAGES_PAGE_URL = "https://northwellhealth.followmyhealth.com/patientaccess#/Inbox",
            WELLNESS_PAGE_URL = "https://northwellhealth.followmyhealth.com/patientaccess#/Wellness/MeasurementsBloodPressure",
            BOOKIT_API = ConfigurationReader.getProperty("BOOKIT_API"),
            BOOKIT_URI_BD = ConfigurationReader.getProperty("BOOKIT.URI.BD"),
            TEACHER_EMAIL = ConfigurationReader.getProperty("teacher.email"),
            TEACHER_PASSWORD = ConfigurationReader.getProperty("teacher.password"),
            TEAMMEMBER_EMAIL = ConfigurationReader.getProperty("team.member.email"),
            TEAMMMEMBER_PASSWORD = ConfigurationReader.getProperty("team.member.password"),
            TEAMLEADER_EMAIL = ConfigurationReader.getProperty("team.leader.email"),
            TEAMLEADER_PASSWORD = ConfigurationReader.getProperty("team.leader.password"),
            USER_CREDENTIAL = "email",
            USER_PASSWORD = "password";

    public static Map<String, String> defineCredentials(String type) {
        String email, password;
        String type1 = type.toLowerCase().replaceAll(" ","");
        switch (type1) {
            case "teacher":
                email = TEACHER_EMAIL;
                password = TEACHER_PASSWORD;
                break;
            case "leader":
                email = TEAMLEADER_EMAIL;
                password = TEAMLEADER_PASSWORD;
                break;
            case "member":
                email = TEAMMEMBER_EMAIL;
                password = TEAMMMEMBER_PASSWORD;
                break;
            default:
                throw new NullPointerException("Non-Existed User! " + type);
        }
        return new HashMap<String, String>() {
            {
                put(USER_CREDENTIAL, email);
                put(USER_PASSWORD, password);
            }
        };
    }

}

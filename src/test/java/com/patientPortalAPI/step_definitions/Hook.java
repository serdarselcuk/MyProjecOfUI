package com.patientPortalAPI.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.utils.Constants.BOOKIT_API;
import static io.restassured.RestAssured.baseURI;

public class Hook {

    @Before("@API_tests")
    public void startUp() {
        baseURI = BOOKIT_API;
        System.out.println("Base_URI have been initialized");
    }

    @After("@API_tests")
    public void tearDown() {
        Authentication_Steps.softAssert.assertAll();
        System.out.println("end of API");
    }


}
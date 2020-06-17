package com.utils;

import io.restassured.response.Response;

import java.util.Map;

import static com.utils.Constants.BOOKIT_API;
import static com.utils.Constants.defineCredentials;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetAPI_Token {

    static {
        baseURI = BOOKIT_API;
    }

    private final String API_Token;

    //sign?email=teacherva5@gmail.com&password=maxpayne
    private GetAPI_Token(String role) {

        Map<String, String> credentials = defineCredentials(role);

        Response response = given()
                .queryParams(credentials)
                .when()
                .get("/sign");
        response.then()
                .statusCode(200);

        API_Token = response.path("accessToken");

    }

    static public String get(String role) {

        GetAPI_Token token = new GetAPI_Token(role);
        return token.API_Token;
    }


}
package com.patientPortalAPI.ApiResponses;

import io.restassured.response.Response;

import static com.utils.Constants.defineCredentials;
import static io.restassured.RestAssured.given;

public class Responses {


    public Response getAuthTokenResponse(String role) {


        Response response = given()
                .queryParams(defineCredentials(role))
                .when()
                .get("/sign");

        return response;
    }


}

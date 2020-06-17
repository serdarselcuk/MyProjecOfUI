package com.patientPortalAPI.step_definitions;

import com.utils.GetAPI_Token;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public class DefinitionSteps {
    String token;
    RequestSpecification requestSpecification;
    Response response;

    @Given("authorization token is provided for (role){string}")
    public void authorizationTokenIsProvidedFor(String role) {
        token = GetAPI_Token.get(role);
    }

    @And("user accepts content type as (contentType){string}")
    public void userAcceptsContentTypeAs(String contentType) {
        requestSpecification = RestAssured.given().contentType(contentType);
    }

    @When("user sends POST request to {string} with following information:")
    public void userSendsPOSTRequestToWithFollowingInformation(String path, List<Map<String, String>> students) {
        for (Map<String, String> student : students) {
            response = requestSpecification.auth().oauth2(token).queryParams(student).when().post(path);
        }
    }

    @And("user verifies that response status code is {int}")
    public void userVerifiesThatResponseStatusCodeIs(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }


}

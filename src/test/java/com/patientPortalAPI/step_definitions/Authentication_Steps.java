package com.patientPortalAPI.step_definitions;

import com.patientPortalAPI.ApiResponses.Responses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

public class Authentication_Steps {
    public static SoftAssertions softAssert;
    Responses responses;
    Response response;

    @Given("BaseUri is defined")
    public void baseuriIsDefined() {

        softAssert = new SoftAssertions();
        responses = new Responses();

    }

    @When("(user){string} send request for Authentication")
    public void userSendRequestForAuthentication(String userType) {

        response = responses.getAuthTokenResponse(userType);

    }

    @And("values should be the same")
    public void valuesShouldBeTheSame() {
        softAssert.assertThat(response.path("accessToken").toString()).isEqualTo(response.path("refreshToken").toString());

    }

    @And("status code is")
    public void statusCodeIs() {
        softAssert.assertThat(response.statusCode()).isEqualTo(200);
    }

    @Then("Token is {int} character length")
    public void tokenIsCharacterLength(int num) {
        softAssert.assertThat(response.path("accessToken").toString().length()).isEqualTo(num);
    }
}

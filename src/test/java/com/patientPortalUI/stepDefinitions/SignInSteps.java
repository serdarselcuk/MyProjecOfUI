package com.patientPortalUI.stepDefinitions;

import com.helpers.TestContext;
import com.patientPortalUI.pages.HomePage;
import com.patientPortalUI.pages.SignInPage;
import com.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class SignInSteps {

    TestContext context;

    public SignInSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the sign in page")
    public void iAmOnTheSignInPage() {
        context.page = new SignInPage();
    }

    @Given("(Large Sign In button){string} Is clicked")
    public void LargeSignInButtonIsClicked(String button) {

        if (context.page.elementIsDisplayed(button)) {
            context.page.clickOn(button);
        }
    }


    @And("I see (text box){string}")
    public void iSeeTextBox(String textBox) {
        Assert.assertTrue(textBox + " Text box didn't displayed", context.page.elementIsDisplayed(textBox));
    }


    @Then("elements below should be displayed")
    public void elementsBelowShouldBeDisplayed(List<String> elements) {
        elements.forEach(
                element ->
                        Assert.assertTrue(element + " element couldn't displayed", context.page.elementIsDisplayed(element))
        );
    }


    @When("I write user credentials in the text boxes")
    public void IWriteUserCredentialsTextBoxes() {

        Assert.assertTrue("Send Credentials could not be succeeded", ((SignInPage) context.page).sendCredentials());
    }


    @And("click on the {string}(sign in button)")
    public void clickOn(String button) {
        context.page.clickOn(button);
    }


    @Then("Home Page is open")
    public void homePageIsOpen() {
        context.page = new HomePage();
        Assert.assertEquals("home page does not opened", Constants.HOME_PAGE_URL, context.page.getPageUrl());
    }


    @When("I provided my credentials and login")
    public void iProvidedMyCredentialsAndLogin() {

        if (context.page.elementIsDisplayed("Large Sign In button")) {
            context.page.clickOn("Large Sign In button");
        }
        ((SignInPage) context.page).login();

    }
}



package com.patientPortalUI.stepDefinitions;

import com.helpers.TestContext;
import com.patientPortalUI.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class HomePageSteps {

    TestContext context;

    public HomePageSteps(TestContext context) {
        this.context = context;
    }

    @Given("User get the information on action center on home page")
    public void userGetTheInformationOnActionCenterOnHomePage() {
        context.page = new HomePage();
        context.actionCenterWarning = context.page.getTextOfElement("actionCenterViews");
    }

    @And("Absent of address information is mentioned")
    public void absensOfAddressInformationIsMentioned() {

        Assert.assertThat("Action Center Warning is null: " + context.actionCenterWarning, is(notNullValue()));
    }

    @When("I click on (Pages){string} on the navigation tab")
    public void iClickOnPagesOnTheNavigationTab(String feature) {

        context.page.navigateTo(feature);
        context.featureName = feature;
    }

    @Then("Related page is open")
    public void relatedPageIsOpen() {

        Assert.assertThat(context.page.getPageUrl(), is(context.expectedPage_URL()));
    }

}
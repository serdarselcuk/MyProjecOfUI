package com.patientPortalUI.stepDefinitions;

import com.helpers.TestContext;
import com.patientPortalUI.pages.MyHealthSummaryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesPattern;


public class MyHealthSummaryTestSteps {


    TestContext context;

    public MyHealthSummaryTestSteps(TestContext context) {
        this.context = context;
    }


    @Then("I see my Birthday")
    public void ISeeMyBirthday() {

        Assert.assertThat(context.page.getTextOfElement("Birthday Text"), matchesPattern("([\\d][\\d]\\/)([\\d][\\d]\\/)([\\d][\\d][\\d][\\d])"));
    }


    @Given("My preferred name is {string}")
    public void myPreferredNameIs(String name) {

        context.prefferedName = name;
    }


    @And("I navigate to (My Health){string} page")
    public void i_navigate_to_My_Health_page(String page) {
        context.page.navigateTo(page);
        context.page = new MyHealthSummaryPage();
    }


    @Then("I see my address information")
    public void ISeeMyAddressInformation() {

        Assert.assertThat(context.page.getTextOfElement("Address Text"), containsString("New York"));
    }


    @Then("I see my full-name the same with preferred name")
    public void iSeeMyFullNameTheSameWithPreferredName() {

        Assert.assertThat(context.page.getTextOfElement("Summary Demographics"), containsString(context.prefferedName));
    }


}

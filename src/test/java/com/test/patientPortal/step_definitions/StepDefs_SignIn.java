package com.test.patientPortal.step_definitions;

import com.test.patientPortal.pages.BasePage;
import com.test.patientPortal.pages.Sign_In_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.util.List;

import static com.test.patientPortal.pages.Sign_In_Page.PAGE_TITLE;

public class StepDefs_SignIn {

    SoftAssertions softAssert;
    BasePage page;

    @Given("I am setting test Environment")
    public void setTestEnvironment() {

        softAssert = new SoftAssertions();
        page = new Sign_In_Page();
    }


    @Given("I am on the page")
    public void i_am_on_the_signIn_page() {

        Assert.assertEquals("Page couldn't been corrected", PAGE_TITLE, page.actualTitle());

    }

    @When("I check for all the elements of page below")
    public void i_check_for_all_the_elements_below(List<String> dataTable) {

        dataTable.forEach(p ->
                softAssert.assertThat(page.getElementByName(p)
                        .isDisplayed())

        );
    }

    @Then("Elements should be displayed on the page")
    public void elements_should_be_displayed_on_the_page() {

        softAssert.assertAll();
    }

    @When("I clicked on {string} choice")
    public void i_clicked_on_choise(String choice) {

        page.clickOn(choice);
    }

    @Then("the element should be shown")
    public void the_element_should_be_shown() {
        System.out.println("the element should be shown");
    }

    @Then("I should see {int} button like in the list below")
    public void i_should_see_button_like_in_the_list_below(Integer int1, io.cucumber.datatable.DataTable dataTable) {
        System.out.println(int1 + " \ndata table" + dataTable);
    }


    @And("there is two choice active like below:")
    public void thereIsChoiseActiveLikeBelow(List<String> list) {

        Assert.assertEquals(list, page.textOfElement("englishdropdown"));
    }

    @Then("in drop-down {string} button the language is {string} chosen")
    public void in_drop_down_button_the_language_is_chosen(String elementName, String selected) {

        Assert.assertTrue(page.optionIsSelected(selected));
    }

}
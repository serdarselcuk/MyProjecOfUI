@UI_Tests @HomePage
Feature: I should be able use Home page to use my account efficiently


  Background: User logs In follow my health address successfully
    Given I am on the sign in page
    When I provided my credentials and login
    Then Home Page is open

  Scenario: As user I should be warned about my miss-information
    Given User get the information on action center on home page
    Then Absent of address information is mentioned

  @out

  Scenario Outline: Features buttons should be navigate me related page to be able to use all features
    When I click on "<Pages>" on the navigation tab
    Then Related page is open
    Examples:
      | Pages     |
      | Home      |
      | Messages  |
      | My Health |
      | Wellness  |
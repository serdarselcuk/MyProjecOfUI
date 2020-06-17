@UI_Tests @Login
Feature:Sign in page

  Background:Opens the signing-in page
    Given I am on the sign in page


  Scenario:Sign in elements should be masked by bigger Sign In Button
    Given "Large Sign In button" Is clicked
    When I see "user name text box"
    Then elements below should be displayed
      | Sign In Button       |
      | User Name Text Box   |
      | Password Text Box    |
      | Show PassWord Button |


  Scenario: User should be log-in successfully
    Given "Large Sign In button" Is clicked
    When I write user credentials in the text boxes
    And click on the "sign in button"
    Then Home Page is open
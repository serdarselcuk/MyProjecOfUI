@API_tests
Feature: End Points should be respond properly with the rigrht status code in accaptable time limit

  Scenario Outline: As a defined <user> I should be able to get Auth code successfully
    Given BaseUri is defined
    When "<user>" send request for Authentication
    Then Token is 40 character length
    And values should be the same
    And status code is
    Examples:
      | user        |
      | Teacher     |
      | Team Lead   |
      | Team Member |


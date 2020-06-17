@API_tests
Feature: CustomerOwner should be able to create user but not the other users to protect data

  Scenario: 1. Create student as a team member and verify status code 422
    Given authorization token is provided for "team member"
    And user accepts content type as "application/json"
    When user sends POST request to "/api/students/student" with following information:
      | first-name | last-name | email             | password | role                | campus-location | batch-number | team-name      |
      | Martin     | Lamberg   | marteen@email.com | 1111     | student-team-member | VA              | 12           | Online_Hackers |
    And user verifies that response status code is 403

  Scenario: 2. Create student as a teacher and verify status code 201
    Given authorization token is provided for "teacher"
    And user accepts content type as "application/json"
    When user sends POST request to "/api/students/student" with following information:
      | first-name | last-name | email             | password | role                | campus-location | batch-number | team-name      |
      | Martin     | Lamberg   | marteen@email.com | 1111     | student-team-member | VA              | 12           | Online_Hackers |
    And user verifies that response status code is 201
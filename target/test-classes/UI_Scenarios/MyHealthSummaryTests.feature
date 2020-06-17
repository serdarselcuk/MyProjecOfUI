@UI_Tests @MyHealthSummary
Feature:My health summary page should be properly working so user can follow own health

  Background: User logs In follow my health address successfully
    Given I am on the sign in page
    And I provided my credentials and login
    And Home Page is open


  Scenario: User should see (his/her) name as mentioned in
    Given My preferred name is "Ser SELCUK"
    And I navigate to "My Health" page
    Then I see my full-name the same with preferred name
    And I see my address information
    And I see my Birthday

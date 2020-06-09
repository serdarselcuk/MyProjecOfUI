@Login
Feature:Sign in page

  Background:Opens the signing-in page
    Given I am setting test Environment


  Scenario:check the page for all of the elements
    Given I am on the page
    When I check for all the elements of page below
      | User Name Text Box    |
      | Password Text Box     |
      | Show Pass Word Button |
      | Sign In Button        |
      | Contact UsLink        |
      | About                 |
      | app Store             |
      | Google Play           |
    Then Elements should be displayed on the page


  Scenario:DropDown Button working properly
    Given I am on the page
    When I clicked on "english DropDown" choice
    Then in drop-down "english DropDown" button the language is "English" chosen
    And there is two choice active like below:
      | English |
      | Espanol |

  Scenario:Hidden use an alternative option working properly
    Given I am on the page
    When I clicked on "use An Alternative" choice
    Then the element should be shown
    And I should see 6 button like in the list below
      | Apple     |
      | Cerner    |
      | Facebook  |
      | Google    |
      | Microsoft |
      | Yahoo     |

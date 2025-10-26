Feature: Body Mass Index Calculator
  As a user
  I want to find out my BMI
  So that I can track my health

  Scenario: Calculate BMI using metric units
    Given I open the BMI site
    When I choose metric units
    And I provide age as "26"
    And I provide gender as "male"
    And I provide height as "182" cm
    And I provide weight as "78" kg
    And I press calculate
    Then BMI result should appear
    And BMI category should appear

  Scenario: Calculate BMI using US units
    Given I open the BMI site
    When I choose US units
    And I provide age as "32"
    And I provide gender as "female"
    And I provide height feet as "5" and inches as "7"
    And I provide weight as "145" pounds
    And I press calculate
    Then BMI result should appear
    And BMI category should appear

  Scenario: Clear BMI calculation
    Given I open the BMI site
    When I choose metric units
    And I provide age as "26"
    And I provide gender as "male"
    And I provide height as "182" cm
    And I provide weight as "78" kg
    And I press calculate
    And I press clear
    Then All inputs should reset

  Scenario Outline: Calculate BMI for various users
    Given I open the BMI site
    When I choose metric units
    And I provide age as "<age>"
    And I provide gender as "<gender>"
    And I provide height as "<height>" cm
    And I provide weight as "<weight>" kg
    And I press calculate
    Then BMI result should appear

    Examples:
      | age | gender | height | weight |
      | 24  | male   | 174    | 68     |
      | 38  | female | 167    | 60     |
      | 45  | male   | 180    | 90     |
      | 31  | female | 159    | 65     |


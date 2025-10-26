Feature: BMI Calculator

  Scenario: Calculate BMI for a person
    Given user is on BMI Calculator page
    When user enters height "173" cm and weight "70" kg
    And user clicks on Calculate button
    Then BMI result should be displayed

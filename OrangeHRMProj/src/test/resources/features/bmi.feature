Feature: BMI Calculator

  Scenario: Calculate BMI for a person
    Given user is on BMI Calculator page
    When user enters height "180" cm and weight "75" kg
    And user clicks on Calculate button
    Then BMI result should be displayed

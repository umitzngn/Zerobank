@pay
Feature: Pay Bills

  Background:
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Pay Bills button

  Scenario: Login Pay Bills page
    Then The user should be able to see the title "Zero - Pay Bills"

  Scenario: The user should see the successfully submitted message
    Then The user enters the "200" in Amount box
    Then The user enters the "2020-09-20" in date box
    Then The user clicks pay button
    And The user should able to see the successfully submitted message "The payment was successfully submitted."
  @smoke
  Scenario: The user tries to make a payment without entering the amount
    Then The user enters the "200" in Amount box
    Then The user clicks pay button
    And The user should be able to see failure message "Please fill out this field."

  Scenario: The user tries to make a payment without entering the date
    Then The user enters the "2020-09-20" in date box
    Then The user clicks pay button
    And The user should be able to see failure message "Please fill out this field." on Amount box

  Scenario: Amount field should not accept alphabetical characters
    Then The user should not able to enter alphabetical or special characters in amount box

  Scenario: Date field should not accept alphabetical characters
    Then The user should not able to enter alphabetical characters in date box





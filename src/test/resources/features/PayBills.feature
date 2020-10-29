Feature: Pay Bills

  Scenario: Login Pay Bills page
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Pay Bills button
    Then The user should be able to see the title "Zero – Pay Bills"

  Scenario: The user should see the successfully submitted message
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Pay Bills button
    Then The user enters the "value" in Amount box
    Then The user enters the "date" in date box
    Then The user clicks pay button
    And The user should able to see the message "The payment was successfully submitted."

  Scenario: The user tries to make a payment without entering the amount
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Pay Bills button
    Then The user enters the "value" in Amount box
    Then The user clicks the Pay button
    And The user should be able to see failure message "Please fill out this field message!"

  Scenario: The user tries to make a payment without entering the date
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Pay Bills button
    Then The user enters the "date" in date box
    Then The user clicks the Pay button
    And The user should be able to see failure message "Please fill out this field message!"

  Scenario: Amount field should not accept alphabetical characters
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Pay Bills button
    Then The user should not able to enter alphabetical or special characters in amount box


  Scenario: Date field should not accept alphabetical characters
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Pay Bills button
    Then The user should not able to enter alphabetical characters in date box





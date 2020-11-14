@login @smoke @regression
Feature: Only authorized users should be able to login to the application

  Background: login page
    Given The user is on the login page

  Scenario: login with the valid credential
    When The user enters the valid credential
    Then The user should be able to login

  Scenario: login with the invalid username credential
    When The user enters the invalid username credential
    Then The user should see the error message "Login and/or password are wrong."

  Scenario: login with the invalid password credential
    When The user enters the invalid password credential
    Then The user should see the error message "Login and/or password are wrong."

  Scenario: login with without username
    When the user does not enter any username
    Then The user should see the error message "Login and/or password are wrong."

  Scenario: login with without password
    When the user does not enter any password
    Then The user should see the error message "Login and/or password are wrong."



  Scenario: login with the valid credential
    Given The user is on the login page
    When The user enters the valid credential
    Then The user should be able to login


  Scenario Outline: invalid
    Given The user is on the login page
    When The user enters the invalid <"value"> credential
    Then The user should see the error message "Login and/or password are wrong."

    Examples:
      | invalid_admin_username |
      | invalid_admin_password |
      | empty_admin_username   |
      | empty_admin_password   |

@login
Feature: Only authorized users should be able to login to the application

  Scenario: login with the valid credential
    Given The user is on the login page
    When The user enters the valid credential
    Then The user should be able to login

  Scenario: login with the invalid username credential
    Given The user is on the login page
    When The user enters the invalid username credential
    Then The user should see the error message "Login and/or password are wrong."

  Scenario: login with the invalid password credential
    Given The user is on the login page
    When The user enters the invalid password credential
    Then The user should see the error message "Login and/or password are wrong."

  Scenario: login with without username
    Given The user is on the login page
    When the user does not enter any username
    Then The user should see the error message "Login and/or password are wrong."

  Scenario: login with without password
    Given The user is on the login page
    When the user does not enter any password
    Then The user should see the error message "Login and/or password are wrong."

@summary
Feature: Account Summary

  Background:
    Given The user is on the login page
    When The user enters the valid credential

  Scenario: Login Account Summary page
    Then The user should be able to see the title "Zero - Account Summary"

  @smoke
  Scenario: Account types should be displayed
    Then Account Summary page should have to account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
  @smoke
  Scenario: Credit Accounts table must have columns
    Then Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |


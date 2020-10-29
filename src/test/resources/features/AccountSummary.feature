@summary
Feature: Account Summary

  Scenario: Login Account Summary page
    Given The user is on the login page
    When The user enters the valid credential
    Then The user should be able to see the title "Zero - Account Summary"

  Scenario: Account types should be displayed
    Given The user is on the login page
    When The user enters the valid credential
    Then Account Summary page should have to account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table must have columns
    Given The user is on the login page
    When The user enters the valid credential
    Then Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |


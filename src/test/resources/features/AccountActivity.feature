Feature: Account Activity

  Background: Account Activity
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Account Activity button

  @smoke
  Scenario: Login Account Activity page
    Then The user should be able to see the title "Zero - Account Activity"

  Scenario: In the Account drop down default option should be Savings
    Then Account drop down should have Savings selected

  @smoke
  Scenario: Account drop down options should be displayed
    Then Account drop down should have the options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions table should have column
    Then Transactions table should have columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |





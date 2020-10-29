Feature: Account Activity

  Scenario: Login Account Activity page
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Account Activity button
    Then The user should be able to see the title "Zero - Account Activity"

  Scenario: In the Account drop down default option should be Savings
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Account Activity button
    Then Account drop down should have Savings selected
  @wip
  Scenario: Account drop down options should be displayed
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Account Activity button
    Then Account drop down should have the options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions table should have column
    Given The user is on the login page
    When The user enters the valid credential
    Then The user clicks the Account Activity button
    Then Transactions table should have columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |





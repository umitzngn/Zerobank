$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AccountActivity.feature");
formatter.feature({
  "name": "Account Activity",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Transactions table should have column",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "The user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user enters the valid credential",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepDefs.the_user_enters_the_valid_credential()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user clicks the Account Activity button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AccountActivityDefs.the_user_clicks_the_Account_Activity_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Transactions table should have columns",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AccountActivityDefs.transactions_table_should_have_columns(java.util.List\u003cjava.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
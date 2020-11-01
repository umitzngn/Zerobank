$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/PayBills.feature");
formatter.feature({
  "name": "Pay Bills",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@pay"
    }
  ]
});
formatter.scenario({
  "name": "Date field should not accept alphabetical characters",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@pay"
    },
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
  "name": "The user clicks the Pay Bills button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBillsDefs.the_user_clicks_the_Pay_Bills_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user should not able to enter alphabetical characters in date box",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBillsDefs.the_user_should_not_able_to_enter_alphabetical_characters_in_date_box()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
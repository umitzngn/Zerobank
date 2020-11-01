package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PayBillsDefs {
    @Then("The user clicks the Pay Bills button")
    public void the_user_clicks_the_Pay_Bills_button() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.payBills.click();
    }

    @Then("The user enters the {string} in Amount box")
    public void the_user_enters_the_in_Amount_box(String value) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amountBox.sendKeys(value);

    }

    @Then("The user enters the {string} in date box")
    public void the_user_enters_the_in_date_box(String date) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.dateBox.sendKeys(date);
    }

    @Then("The user clicks pay button")
    public void the_user_clicks_pay_button() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payButton.click();
    }

    @Then("The user should able to see the successfully submitted message {string}")
    public void the_user_should_able_to_see_the_successfully_submitted_message(String expectedMessage) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String actualMessage = payBillsPage.successfulSubmittedMessage.getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("The user should be able to see failure message {string}")
    public void the_user_should_be_able_to_see_failure_message(String expectedMessage) {
        String actualMessage = new PayBillsPage().dateBox.getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("The user should be able to see failure message {string} on Amount box")
    public void the_user_should_be_able_to_see_failure_message_on_Amount_box(String expectedMessage) {
        String actualMessage = new PayBillsPage().amountBox.getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("The user should not able to enter alphabetical or special characters in amount box")
    public void the_user_should_not_able_to_enter_alphabetical_or_special_characters_in_amount_box() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amountBox.sendKeys("exampleSentenceWithSpecialChar###");

        String actualResult = payBillsPage.amountBox.getText();
        Assert.assertTrue(actualResult.isEmpty());
        //There is a bug in this scenario, the user can enter characters in amount box, but he/she should not able to
    }

    @Then("The user should not able to enter alphabetical characters in date box")
    public void the_user_should_not_able_to_enter_alphabetical_characters_in_date_box() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.dateBox.sendKeys("exampleSentence");

        String actualResult = payBillsPage.dateBox.getText();
        Assert.assertTrue(actualResult.isEmpty());
    }
}

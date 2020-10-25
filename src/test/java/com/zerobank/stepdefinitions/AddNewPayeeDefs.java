package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeDefs {
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("admin_username");
        String password = ConfigurationReader.get("admin_password");

        loginPage.login(username, password);

        BrowserUtils.waitFor(2);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.payBills.click();

        BrowserUtils.waitFor(2);
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.addNew.click();

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> addPayee) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payeeName.sendKeys(addPayee.get("Payee Name"));
        BrowserUtils.waitFor(2);
        payBillsPage.payeeAddress.sendKeys(addPayee.get("Payee Address"));
        payBillsPage.account.sendKeys(addPayee.get("Account"));
        payBillsPage.payeeDetails.sendKeys(addPayee.get("Payee details"));

        payBillsPage.addButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        PayBillsPage payBillsPage = new PayBillsPage();
        String actualMessage = payBillsPage.alertMessage.getText();
        String expectedMessage = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";

        Assert.assertEquals(expectedMessage,actualMessage);
    }

}

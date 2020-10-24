package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


public class AccountActivityNavigationDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("admin_username");
        String password = ConfigurationReader.get("admin_password");

        loginPage.login(username,password);
    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.Savings.click();

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Activity";

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {

        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Select accountSelect = new Select(accountActivityPage.dropdown);

        String actualSelectedOption = accountSelect.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Savings";

        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.Brokerage.click();
    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Select accountSelect = new Select(accountActivityPage.dropdown);

        String actualSelectedOption = accountSelect.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Brokerage";

        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);

    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.Checking.click();
    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Select accountSelect = new Select(accountActivityPage.dropdown);

        String actualSelectedOption = accountSelect.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Checking";

        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);

    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.CreditCard.click();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Select accountSelect = new Select(accountActivityPage.dropdown);

        String actualSelectedOption = accountSelect.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Credit Card";

        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);

    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.Loan.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Select accountSelect = new Select(accountActivityPage.dropdown);

        String actualSelectedOption = accountSelect.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Loan";

        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);

    }


}

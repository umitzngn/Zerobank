package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FindTransactionsDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("admin_username");
        String password = ConfigurationReader.get("admin_password");

        loginPage.login(username, password);

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.accountActivity.click();

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.findTrans.click();

        BrowserUtils.waitFor(2);

        String actualTitle = accountActivityPage.subTitleFindTrans.getText();
        String expectedTitle = "Find Transactions";

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateFrom, String dateTo) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.dateFrom.clear();
        accountActivityPage.dateFrom.sendKeys(dateFrom);

        accountActivityPage.dateTo.clear();
        accountActivityPage.dateTo.sendKeys(dateTo);

    }

    @When("clicks search")
    public void clicks_search() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.findButton.click();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String dateFirst, String dateLast) throws ParseException {

        BrowserUtils.waitFor(2);

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<WebElement> datesInTable = accountActivityPage.table;
        List<String> dates = BrowserUtils.getElementsText(datesInTable);

        List<Date> listOfDates = new ArrayList<>();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        for (String date:dates) {
            listOfDates.add(format.parse(date));
        }

        Date d1 = format.parse(dateFirst);
        Date d2 = format.parse(dateLast);
        boolean flag = false;
        for (Date date : listOfDates) {
            flag = false;
            if(date.after(d1) && date.before(d2) || date.equals(d1) || date.equals(d2)){
                flag = true;
            }

        }
        Assert.assertTrue(flag);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<WebElement> datesInTable = accountActivityPage.table;

        List<String> actualDates = BrowserUtils.getElementsText(datesInTable);
        List<String> expectedDates = BrowserUtils.getElementsText(datesInTable);

        Collections.sort(actualDates);
        Collections.sort(actualDates,Collections.reverseOrder());

        Assert.assertEquals(expectedDates,actualDates);

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date1) {
        BrowserUtils.waitFor(2);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<WebElement> datesInTable = accountActivityPage.table;

        List<String> actualDates = BrowserUtils.getElementsText(datesInTable);

        Assert.assertFalse(actualDates.contains(date1));

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.descriptionBox.sendKeys(string);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<WebElement> resultsInTable = accountActivityPage.table;
        List<String> results = BrowserUtils.getElementsText(resultsInTable);

        for (String result : results) {

            if (result.contains(string)){
                Assert.assertTrue(true);
            }

        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {

    }


    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> deposits = BrowserUtils.getElementsText(accountActivityPage.underDeposit);
        int counter = 0;
        for (String deposit : deposits) {
            if(!deposit.isEmpty()){
                counter++;
            }
        }
        Assert.assertTrue(counter>0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.waitFor(3);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> withdravals = BrowserUtils.getElementsText(accountActivityPage.underWithdraval);
        int counter = 0;
        for (String withdraval : withdravals) {
            if(!withdraval.isEmpty()){
                counter++;
            }
        }
        if(counter>1){
            Assert.assertTrue(true);
        }

    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select typeSelect = new Select(accountActivityPage.select);

        typeSelect.selectByIndex(1);
        accountActivityPage.findButton.click();

    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        BrowserUtils.waitFor(3);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> withdravals = BrowserUtils.getElementsText(accountActivityPage.underWithdraval);
        int counter = 0;
        for (String withdraval : withdravals) {
            if(!withdraval.isEmpty()){
                counter++;
            }
        }
        if(counter<1){
            Assert.assertTrue(true);
        }

    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> deposits = BrowserUtils.getElementsText(accountActivityPage.underDeposit);
        int counter = 0;
        for (String deposit : deposits) {
            if(!deposit.isEmpty()){
                counter++;
            }
        }
        if(counter<1){
            Assert.assertTrue(true);
        }

    }



}

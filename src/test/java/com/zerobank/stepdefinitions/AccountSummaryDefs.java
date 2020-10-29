package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryDefs {
    @Then("The user should be able to see the title {string}")
    public void the_user_should_be_able_to_see_the_title(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account Summary page should have to account types")
    public void account_Summary_page_should_have_to_account_types(List<String> expectedAccountTypes) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountSummaryPage.accountTypes);
        Assert.assertEquals(expectedAccountTypes,actualAccountTypes);
    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> expectedColumns) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualColumns = BrowserUtils.getElementsText(accountSummaryPage.columns);
        Assert.assertEquals(expectedColumns,actualColumns);
    }
}

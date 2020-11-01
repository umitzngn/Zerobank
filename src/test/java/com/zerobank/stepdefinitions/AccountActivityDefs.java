package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityDefs {
    @Then("The user clicks the Account Activity button")
    public void the_user_clicks_the_Account_Activity_button() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.accountActivity.click();
    }

    @Then("Account drop down should have the options")
    public void account_drop_down_should_have_the_options(List<String> expectedAccountOptions) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select accountOptions = new Select(accountActivityPage.dropdown);

        List<String> actualAccountOptions = BrowserUtils.getElementsText(accountOptions.getOptions());

        boolean flag = false;
        for (int i = 0; i < actualAccountOptions.size(); i++) {
            for (int j = 0; j < expectedAccountOptions.size(); j++) {
                if (actualAccountOptions.get(i).equals(expectedAccountOptions.get(j))){
                    flag = true;
                }
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("Transactions table should have columns")
    public void transactions_table_should_have_columns(List<String> expectedColumns) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualColumns = BrowserUtils.getElementsText(accountActivityPage.columns);
        Assert.assertEquals(expectedColumns,actualColumns);
    }
}

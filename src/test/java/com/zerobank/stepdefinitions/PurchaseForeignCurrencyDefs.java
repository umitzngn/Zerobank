package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyDefs {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("admin_username");
        String password = ConfigurationReader.get("admin_password");

        loginPage.login(username, password);

        BrowserUtils.waitFor(2);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.payBills.click();

        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.purchaseForeign.click();
        BrowserUtils.waitFor(3);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Select selectCurrencies = new Select(new PayBillsPage().select);
        List<WebElement> options = selectCurrencies.getOptions();
        List<String> expectedCurrencies = BrowserUtils.getElementsText(options);

        boolean flag = false;
        for (int i = 0; i < expectedCurrencies.size(); i++) {
            for (int j = 0; j < dataTable.size(); j++) {
                if (expectedCurrencies.get(i).equals(dataTable.get(j))){
                    flag = true;
                }
            }
        }
        Assert.assertTrue(flag);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amount.sendKeys("1000");
        payBillsPage.calculate.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        BrowserUtils.waitFor(2);
        String expectedMessage = "Please, ensure that you have filled all the required fields with valid values.";
        String actualMessage=Driver.get().switchTo().alert().getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.calculate.click();
    }


}

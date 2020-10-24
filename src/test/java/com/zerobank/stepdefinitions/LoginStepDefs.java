package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters the valid credential")
    public void the_user_enters_the_valid_credential() {
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("admin_username");
        String password = ConfigurationReader.get("admin_password");
        loginPage.login(username,password);
    }

    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
        String expectedTitle = "Zero - Account Summary";
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("The user enters the invalid username credential")
    public void the_user_enters_the_invalid_username_credential() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("invalid_admin_username");
        String password = ConfigurationReader.get("admin_password");

        loginPage.login(username,password);
    }

    @When("The user enters the invalid password credential")
    public void the_user_enters_the_invalid_password_credential() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("admin_username");
        String password = ConfigurationReader.get("invalid_admin_password");

        loginPage.login(username,password);
    }

    @Then("The user should see the error message {string}")
    public void the_user_should_see_the_error_message(String expectedMessage) {
        LoginPage loginPage = new LoginPage();
        String actualMessage = loginPage.errorMessage.getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("the user does not enter any username")
    public void the_user_does_not_enter_any_username() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("empty_admin_username");
        String password = ConfigurationReader.get("admin_password");

        loginPage.login(username,password);
    }

    @When("the user does not enter any password")
    public void the_user_does_not_enter_any_password() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("admin_username");
        String password = ConfigurationReader.get("empty_admin_password");

        loginPage.login(username,password);
    }

}

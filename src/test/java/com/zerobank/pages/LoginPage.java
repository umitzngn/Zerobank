package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement userLogin;

    @FindBy(id = "user_password")
    public WebElement userPassword;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    public void login(String username, String password){
        signInButton.click();
        userLogin.sendKeys(username);
        userPassword.sendKeys(password);
        submit.click();

    }

}

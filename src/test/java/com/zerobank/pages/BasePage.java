package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(linkText = "Account Activity")
    public WebElement accountActivity;


}

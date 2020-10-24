package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Savings")
    public WebElement Savings;

    @FindBy(linkText = "Brokerage")
    public WebElement Brokerage;

    @FindBy(linkText = "Checking")
    public WebElement Checking;

    @FindBy(linkText = "Credit Card")
    public WebElement CreditCard;

    @FindBy(linkText = "Loan")
    public WebElement Loan;








}

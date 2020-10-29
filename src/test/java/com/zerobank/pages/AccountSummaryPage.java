package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//li[@id='pay_bills_tab']/a")
    public WebElement payBills;

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//div[3]/div/table/thead/tr/th")
    public List<WebElement> columns;









}

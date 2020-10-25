package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement dropdown;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTrans;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[1]")
    public List<WebElement> table;

    @FindBy(xpath = "(//h2[@class='board-header'])[2]")
    public WebElement subTitleFindTrans;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[3]")
    public List<WebElement> underDeposit;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[4]")
    public List<WebElement> underWithdraval;

    @FindBy(id = "aa_type")
    public WebElement select;





}

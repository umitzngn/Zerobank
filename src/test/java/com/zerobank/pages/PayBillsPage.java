package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBillsPage extends BasePage{
    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[2]/a")
    public WebElement addNew;

    @FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[3]/a")
    public WebElement purchaseForeign;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement account;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "alert_content")
    public WebElement alertMessage;

    @FindBy(id = "pc_currency")
    public WebElement select;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculate;

    @FindBy(id = "pc_amount")
    public WebElement amount;

}

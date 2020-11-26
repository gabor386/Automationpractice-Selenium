package pages;

import base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import util.Util;

public class OrderPage extends PageObject {
    public OrderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css= "*[title='Add']")
    WebElement quantity;

    @FindBy(id = "total_product")
    WebElement totalPrice;

    @FindBy(css = ".cart_unit > span > span")
    WebElement unitPrice;

    @FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement checkOutButton;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]/li[3]")
    WebElement deliveryAddressElement;

    @FindBy(xpath="//*[@id=\"address_invoice\"]/li[3]")
    WebElement billingAddressElement;

    @FindBy(id = "cgv")
    WebElement checkBoxTerms;

    @FindBy(partialLinkText = "Pay by bank wire")
    WebElement payPalBankWire;

    @FindBy(css ="button[class*=button-medium]")
    WebElement buttonSubmit;

    public boolean priceCorrection(){
        return   (Double.parseDouble(this.unitPrice.getText().substring(1))*3)
                ==(Double.parseDouble(this.totalPrice.getText().substring(1)));
    }
    public void findQuanity(){ for(int i=0;i<3;i++) this.quantity.click();
    }

    public void checkOutButton() {click(checkOutButton); }


    public void checkAddress(){
        Assert.assertEquals(
                equalTextElement(this.deliveryAddressElement, Util.ADDRESS),
                equalTextElement(this.billingAddressElement,Util.ADDRESS));
        click(buttonSubmit);
    }

    public void setCheckBoxTerms(){
        click(checkBoxTerms);
        click(buttonSubmit);
    }

    public void setPayPalBankWire(){
        click(payPalBankWire);
        click(buttonSubmit);
    }



}

package pages;

import base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Util;

public class ProductPage extends PageObject {
    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "group_1")
    private WebElement productSize;

    @FindBy(name = "White")
    private WebElement productColor;

    @FindBy(css = "#add_to_cart > button > span")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement waitForCart;



    public void waitForCart(){
        WebDriverWait wait=new WebDriverWait(driver, Util.SECONDS_TIMEOUT_20);
        wait.until(ExpectedConditions.visibilityOf(waitForCart)).click();
    }

    public void addtoCart(){
        click(cartButton);
    }

    public void selectSize(){
        Select drop=new Select(productSize);
        drop.selectByVisibleText(Util.SIZE_L);
    }

    public void selectProductColor(){
        click(productColor);
    }



}

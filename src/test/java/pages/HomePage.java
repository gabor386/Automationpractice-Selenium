package pages;

import base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    //proverava 2. element jer 3. element nema belu boju
    @FindBy(xpath="//*[@id=\"homefeatured\"]/li[2]/div/div[2]/h5/a")
    private WebElement productThird;

    public void clickOnThirdProduct(){ click(productThird); }


}

package pages;

import base.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Util;

public class AuthenticationPage extends PageObject {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailElement;

    @FindBy(id="passwd")
    WebElement passwordElement;

    @FindBy(id="SubmitLogin")
    WebElement submitLoginElement;

    public void loginIn(){
        type(Util.EMAIL,emailElement);
        type(Util.PASSWORD,passwordElement);
        click(submitLoginElement);
    }

}

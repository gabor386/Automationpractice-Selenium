package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.Util;

public class PageObject implements Util{
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebDriver getWebDriver(){
        return driver;
    }

    public void click(WebElement element){ element.click(); }

    public void type(String inputText,WebElement element){ element.sendKeys(inputText); }

    public boolean equalTextElement(WebElement element,String s){ return element.getText().equalsIgnoreCase(s); }

//    public Boolean isDiplayeda( By.ByXPath xPath){
//        try {
//            return driver.findElement(xPath).isDisplayed();
//        }catch (org.openqa.selenium.NoSuchElementException e){
//            return  false;
//        }
//
//    }


}


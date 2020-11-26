import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.AuthenticationPage;
import pages.OrderPage;
import pages.ProductPage;
import util.Util;

public class TestPlan {


    private WebDriver driver ;
    private HomePage homePage;
    private ProductPage productPage;
    private OrderPage orderPage;
    private AuthenticationPage authenticationPage;

    @BeforeSuite
    public void setup(){
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Util.CHROME_DRIVER_LOCATION);
        driver=new ChromeDriver();
        homePage=new HomePage(driver);
        productPage=new ProductPage(driver);
        orderPage=new OrderPage(driver);
        authenticationPage=new AuthenticationPage(driver);

        driver.get(Util.BASE_URL);
        driver.manage().window().maximize();
    }

    @Test(testName = "Click on the third product",priority = 0)
    public void thirdProcuct() {
        homePage.clickOnThirdProduct();
    }

    @Test(testName = "Select white and L size ",priority = 1)
    public void prodactSelection() {
        productPage.selectProductColor();
        try {
            productPage.selectSize();
        }catch (org.openqa.selenium.NoSuchElementException e){

        }


    }

    @Test(testName = "Add to char and Wait for popUp",priority = 2)
    public  void addToChar(){
        productPage.addtoCart();
        productPage.waitForCart();
    }
    @Test(testName = "Incres quantity by 4 ",priority = 3)
    public void incresQuantity() {

        orderPage.findQuanity();
    }
    @Test(testName = "Checking the price",priority = 4)
    public void checkingPriceCorrection(){
        orderPage.priceCorrection();
        orderPage.checkOutButton();
    }
    @Test(testName = "Login",priority = 5)
    public void authenticationPageField() {
        authenticationPage.loginIn();
    }

    @Test(testName = "Checking the Address",priority = 6)
    public void personalInfoCheck() {
        orderPage.checkAddress();
    }
    @Test(testName = "ChechBox Field of Terms of service",priority = 7)
    public void checkBoxField() {
        orderPage.setCheckBoxTerms();
    }
    @Test(testName = "PayPal Back wire",priority = 8)
    public void payPalRequirment() {
        orderPage.setPayPalBankWire();
    }


    @AfterSuite
    public  void cleanUp(){
       driver.manage().deleteAllCookies();
        driver.close();
   }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P12_CheckOutPage {
    WebDriver driver;
    public P12_CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    By termsCheckBox = By.id("termsofservice");
    By checkOutBtn = By.id("checkout");

    public P12_CheckOutPage clickOnTermsBox(){
        driver.findElement(termsCheckBox).click();
        return this;
    }

    public P12_CheckOutPage clickOnCheckoutBtn(){
        driver.findElement(checkOutBtn).click();
        return this;
    }


}

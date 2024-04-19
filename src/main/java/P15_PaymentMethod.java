import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P15_PaymentMethod {
    WebDriver driver;

    By creditCard = By.id("paymentmethod_1");
    By moneyOrder = By.id("paymentmethod_0");
    By continueBtn = By.cssSelector("button[class=\"button-1 payment-method-next-step-button\"]");

    public P15_PaymentMethod(WebDriver driver){
        this.driver = driver;
    }

    public P15_PaymentMethod ChooseCreditCard(){
        driver.findElement(creditCard).click();
        return this;
    }

    public P15_PaymentMethod chooseMoneyOrder(){
        driver.findElement(moneyOrder).click();
        return this;
    }

    public P15_PaymentMethod clickOnContinueBtn(){
        driver.findElement(continueBtn).click();
        return this;
    }


}

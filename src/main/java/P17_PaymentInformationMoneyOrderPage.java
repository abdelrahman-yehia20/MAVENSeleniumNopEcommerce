import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P17_PaymentInformationMoneyOrderPage {
    WebDriver driver;
    By continueBtn = By.xpath("//div[@id=\"payment-info-buttons-container\"]/button[@type]");
    public P17_PaymentInformationMoneyOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public P17_PaymentInformationMoneyOrderPage clickOnContinueBtn(){
        driver.findElement(continueBtn).click();
        return this;
    }
}

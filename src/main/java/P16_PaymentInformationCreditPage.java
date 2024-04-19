import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;

public class P16_PaymentInformationCreditPage {

    WebDriver driver;
    Select select;
    By cardHolderName = By.id("CardholderName");
    By cardNumber = By.id("CardNumber");
    By expireYear = By.id("ExpireYear");
    By cardCode = By.id("CardCode");
    By continueBtn = By.xpath("//div[@id=\"payment-info-buttons-container\"]/button");



    public P16_PaymentInformationCreditPage(WebDriver driver){
        this.driver = driver;
    }

    public P16_PaymentInformationCreditPage addCardHolderName(String name){
        driver.findElement(cardHolderName).sendKeys(name);
        return this;
    }

    public P16_PaymentInformationCreditPage addCardNumber(String num){
        driver.findElement(cardNumber).sendKeys(num);
        return this;
    }

    public P16_PaymentInformationCreditPage selectExpireYear(String year){
        select = new Select(driver.findElement(expireYear));
        select.selectByVisibleText(year);
        return this;
    }

    public P16_PaymentInformationCreditPage addCardCode(String num){
        driver.findElement(cardCode).sendKeys(num);
        return this;
    }

    public P16_PaymentInformationCreditPage clickOnContinueBtnnn(){
        driver.findElement(continueBtn).click();
        return this;
    }



}

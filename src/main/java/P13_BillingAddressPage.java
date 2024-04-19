import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class P13_BillingAddressPage {
    WebDriver driver;
    Select select;

    By company = By.id("BillingNewAddress_Company");
    By country = By.id("BillingNewAddress_CountryId");
    By city = By.id("BillingNewAddress_City");
    By address1 = By.id("BillingNewAddress_Address1");
    By address2 = By.id("BillingNewAddress_Address2");
    By postalCode = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By faxNumber = By.id("BillingNewAddress_FaxNumber");
    By continueBtn = By.name("save");

    public P13_BillingAddressPage(WebDriver driver){
        this.driver = driver;
    }

    public P13_BillingAddressPage addCompany(String company){
        driver.findElement(this.company).sendKeys(company);
        return this;
    }

    public P13_BillingAddressPage selectCountry(String country){
        select = new Select(driver.findElement(this.country));
        select.selectByVisibleText(country);
        return this;
    }
    public P13_BillingAddressPage addCity(String city){
        driver.findElement(this.city).sendKeys(city);
        return this;
    }

    public P13_BillingAddressPage addAddress1(String address){
        driver.findElement(this.address1).sendKeys(address);
        return this;
    }

    public P13_BillingAddressPage addAddress2(String address){
        driver.findElement(this.address2).sendKeys(address);
        return this;
    }

    public P13_BillingAddressPage addPostalCode(String num){
        driver.findElement(this.postalCode).sendKeys(num);
        return this;
    }

    public P13_BillingAddressPage addPhoneNumber(String number){
        driver.findElement(this.phoneNumber).sendKeys(number);
        return this;
    }

    public P13_BillingAddressPage addFaxNum(String num){
        driver.findElement(this.faxNumber).sendKeys(num);
        return this;
    }

    public P13_BillingAddressPage clickOnContinueBtn(){
        driver.findElement(this.continueBtn).click();
        return this;
    }






}

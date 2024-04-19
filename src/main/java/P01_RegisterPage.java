import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Year;

public class P01_RegisterPage{

    WebDriver driver;
    Select select ;

    public P01_RegisterPage(WebDriver driver){
        this.driver=driver;
    }


    By regtBtn = By.className("ico-register");
    By male = By.id("gender-male");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By dateOfBirthDay = By.name("DateOfBirthDay");
    By dateOfBirthMonth = By.name("DateOfBirthMonth");
    By dateOfBirthYear = By.name("DateOfBirthYear");
    By email = By.id("Email");
    By password = By.id("Password");
    By confPassword = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");
    By successMsg = By.className("result");

    public P01_RegisterPage openRegisterPage(){
        driver.findElement(regtBtn).click();
        return this;
    }

    public P01_RegisterPage addMaleGender(){
        driver.findElement(male).click();
        return this;
    }
    public P01_RegisterPage addFirstName(String firstName){
        driver.findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public P01_RegisterPage addLastName(String lastName){
        driver.findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public P01_RegisterPage selectDateOfBirthDay(String day){
        select = new Select(driver.findElement(this.dateOfBirthDay));
        select.selectByValue(day);
        return this;
    }

    public P01_RegisterPage selectDateOfBirthMonth(String month){
        select = new Select(driver.findElement(this.dateOfBirthMonth));
        select.selectByValue(month);
        return this;
    }

    public P01_RegisterPage selectDateOfBirthYear(String year){
        select = new Select(driver.findElement(this.dateOfBirthYear));
        select.selectByValue(year);
        return this;
    }

    public P01_RegisterPage addEmail(String email){
        driver.findElement(this.email).sendKeys(email);
        return this;
    }

    public P01_RegisterPage addPassword(String password){
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public P01_RegisterPage addConfirmationPass(String conPass){
        driver.findElement(this.confPassword).sendKeys(conPass);
        return this;
    }
    public P01_RegisterPage clickOnRegisterBtn(){
        driver.findElement(this.registerBtn);
        return this;
    }

    /*
    public P01_RegisterPage fillUserRegisterationForm(String fName, String lName, String email, String password, String confirmPasswod){

        driver.findElement(this.firstName).sendKeys(fName);
        driver.findElement(this.lastName).sendKeys(lName);
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.confPassword).sendKeys(confirmPasswod);
        return this;
    }
*/
    public P01_RegisterPage clickOnRegisterButton(){
        driver.findElement(registerBtn).click();
        return this;
    }

   public Boolean validateThatSuccessMessageShouldBeDisplayed(){
        return driver.findElement(successMsg).isDisplayed();
   }
}

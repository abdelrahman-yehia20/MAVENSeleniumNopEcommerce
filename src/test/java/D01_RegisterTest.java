import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D01_RegisterTest extends TestBase{

    @Test
    public void egistertionFunctionality()
    {

        new P01_RegisterPage(driver).
                openRegisterPage().
                addMaleGender().
                addFirstName("Ahmed").
                addLastName("Ali").
                selectDateOfBirthDay("3").
                selectDateOfBirthMonth("5").
                selectDateOfBirthYear("1990").
                addEmail("test@exampled1.com").
                addPassword("12345678").
                addConfirmationPass("12345678").
                clickOnRegisterButton();

        Assert.assertTrue(new P01_RegisterPage(driver).validateThatSuccessMessageShouldBeDisplayed());
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D04_CurrencyTest extends TestBase {

    @Test
    public void Currency()
    {

        new P04_CurrencyPage(driver).SelectEuro();

        int count = new P04_CurrencyPage(driver).CurrencyResult().size();

        for (int i =0; i<count ;i++)
        {
            String tt = new P04_CurrencyPage(driver).CurrencyResult().get(i).getText();
            Assert.assertTrue(tt.contains("€"));
        }
    }


}

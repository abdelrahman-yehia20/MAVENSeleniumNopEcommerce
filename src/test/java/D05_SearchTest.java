import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D05_SearchTest extends TestBase {



    @Test
    public void SearchWithProductName()
    {
        new P05_SearchPage(driver).SearchWithProductName("ele");

        int count = new P05_SearchPage(driver).searchResultList().size();

        String ss = null;
        for (int x =0; x<count;x++)
        {
             ss = new P05_SearchPage(driver).searchResultList().get(x).getText();
            Assert.assertTrue(ss.toLowerCase().contains("ele"));
        }
    }
}

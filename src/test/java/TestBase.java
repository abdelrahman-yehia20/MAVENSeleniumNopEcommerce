import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestBase {

    public WebDriver driver;

    @BeforeClass
    public void openChrome() throws InterruptedException {

        //1
        //System.setProperty("webdriver.chrome.driver", "D:\\testing\\EGFWD\\chromedriver-win64\\chromedriver.exe");

        //2 Create new object from driver
        driver = new ChromeDriver();

        //3 Navigate to google website, maxmize screen, and sleep
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }



    @AfterClass
    public void closeDriver() throws InterruptedException {


        Thread.sleep(3000);
        // 5 driver close
        driver.quit();
    }



    @AfterMethod
    public void invokeScreenshotMethod(ITestResult res) {
        if (ITestResult.FAILURE == res.getStatus()) {
            Path destination = Paths.get("./screenshots", res.getTestName() + ".png");
            try {

                Files.createDirectories(destination.getParent());
                FileOutputStream out = new FileOutputStream(destination.toString());
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                out.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }



}

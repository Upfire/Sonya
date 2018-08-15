package Core;

import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Core {
    ExtentTest test;
    WebDriver driver;

    public Core( String browserName, String baseURL, ExtentTest test)
    {

        if (browserName.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            test.log(LogStatus.INFO, "Chrome driver initialised");
            driver.manage().window().maximize();
            test.log(LogStatus.INFO, "Maximize window");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(baseURL);
            test.log(LogStatus.INFO, "Open URL: "+baseURL);
        }
        else if (browserName.equalsIgnoreCase("FireFox"))
        {
            System.setProperty("webdriver.chrome.driver", "src/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(baseURL);
        }

    }

    public WebDriver getDriver() {
        return driver;
    }
}

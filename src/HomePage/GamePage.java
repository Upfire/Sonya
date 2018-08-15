package HomePage;

import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class GamePage {
    ExtentTest test;
    WebDriver driver;

   // @FindBy(xpath="//div[@id='buttonsLayer']/div[4]/button") //correct xpath for deal button
   // WebElement dealButton;
   @FindBy(xpath="//div[@id='buttonsLayer']/div[3]/button") //correct xpath for
   WebElement stendButton;


   public GamePage (WebDriver driver, ExtentTest test)
   {
       this.driver = driver;
       this.test = test;

   }

    public void openGame()
    {
        //openGame.click();
        WebElement openGame = driver.findElement(By.id("play_iframe_button"));
        openGame.click();
        test.log(LogStatus.INFO, "Click on Game button ");
    }

    public void acceptCookie()
    {
        WebElement acceptAge = driver.findElement(By.id("cookieAccept"));
        acceptAge.click();
        test.log(LogStatus.INFO, "Accept cookie ");
    }
    public void  acceptAge ()
    {
        WebElement acceptAge = driver.findElement(By.id("age-notice-hero-yes"));
        acceptAge.click();

        test.log(LogStatus.INFO, "Age message accepted ");
    }

    public void swichToIframe()
    {
        driver.switchTo().frame(0);
    }

    public void  takeSit ()
    {
      // WebDriverWait wait = new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.className("takeSit")));

        WebElement ele = driver.findElement(By.className("takeSit"));
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].click();", ele);
        test.log(LogStatus.INFO, "Sit on free sit ");
    }

    public void checkIfPrvRoundEnd ()
    {
        Boolean isPresent = driver.findElements(By.xpath("//button[@class=' positionRelative pointer']")).size()>0;
        if (isPresent == true)
        {
            WebElement ele = driver.findElement(By.xpath("//button[@class=' positionRelative pointer']"));
            JavascriptExecutor exe = (JavascriptExecutor)driver;
            exe.executeScript("arguments[0].click();", ele);
          //driver.findElement(By.xpath("//button[@class=' positionRelative pointer']")).click();
        }
        test.log(LogStatus.INFO, "Previous round dosen`t end");
    }

    public void makeBet (String Bet)
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(Bet)));
        driver.findElement(By.id(Bet)).click();
        test.log(LogStatus.INFO, "Make bet" +Bet);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='buttonsLayer']/div[4]/button")));//div[@id='depth3']/div/div
        driver.findElement(By.xpath("//div[@id='buttonsLayer']/div[4]/button")).click();
        test.log(LogStatus.INFO, "Make deal in game");
    }

    public void dealButt ()
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='buttonsLayer']/div[4]/button")));//div[@id='depth3']/div/div
        driver.findElement(By.xpath("//div[@id='buttonsLayer']/div[4]/button")).click();
        test.log(LogStatus.INFO, "Make deal in game");
    }

    public void waitOtherPlayers ()
    {   WebDriverWait wait = new WebDriverWait(driver, 15);
        //WebElement waitOtherPlayers = driver.findElement(By.xpath("//*[@class=' progress-bar']"));
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.className(" progress-bar"))));
        //waitOtherPlayers.click();
        test.log(LogStatus.INFO, "Make deal in game");
    }

  /*  public void waitEndOfRound ()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='buttonsLayer']/div[3]/button"))));
    }*/

    public void standButt()
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='buttonsLayer']/div[3]/button")));
        driver.findElement(By.xpath("//div[@id='buttonsLayer']/div[3]/button")).click();
        test.log(LogStatus.INFO, "Player stand up");
    }

    public void closeGameButn()
    {
      //  WebDriverWait wait = new WebDriverWait(driver, 15);
     //   wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.className("takeSit"))));
        driver.findElement(By.className("hero-section__close-button")).click();
        test.log(LogStatus.INFO, "Pressed close game button");

    }
}

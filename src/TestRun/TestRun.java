package TestRun;
import Core.Core;
import HomePage.GamePage;
import Logs.ExtendFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;//delete
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestRun {

    Core cor;
    GamePage game;
    ExtentReports report;
    ExtentTest test;


    @BeforeClass
    public void BeforeClass ()
    {
        report = ExtendFactory.getInstance();
        test = report.startTest("Starting test");
        cor = new Core("Chrome", "https://yggdrasilgaming.com/games/sonya-blackjack", test);
        game = new GamePage(cor.getDriver(), test);

    }
    @Test
    public void test1 ()
    {
        game.openGame();
        game.acceptCookie();
        game.acceptAge();
        game.swichToIframe();
        game.takeSit();
        game.checkIfPrvRoundEnd ();
        game.makeBet("100");
        game.dealButt();
        game.standButt();
        game.leaveSteat();
       // game.waitOtherPlayers();
        game.closeGameButn();



    }
    @AfterClass
    public void afterClass() {
        report.endTest(test);
        report.flush();
        cor.getDriver().close();
    }

}

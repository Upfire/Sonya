package Logs;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtendFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent;
        String Path = "C://Users//ylian//Desktop//Reports//report-demo.html";
        extent = new ExtentReports(Path, true);
        extent
                .addSystemInfo("Selenium Version", "3.13")
                .addSystemInfo("Platform", "Windows");

        return extent;
    }

}

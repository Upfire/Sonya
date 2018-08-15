package Logs;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtendFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent;
        String Path = "src/Report/report.html";
        extent = new ExtentReports(Path, true);
        extent
                .addSystemInfo("Selenium Version", "3.13")
                .addSystemInfo("Platform", "Windows");

        return extent;
    }

}

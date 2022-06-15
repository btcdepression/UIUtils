package driver;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static constants.Constants.CHROME;
import static constants.Constants.EDGE;

public class ConfigurationManager {

    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        if (webDriver == null) {
            loadDriver();
        }
        return webDriver;
    }

    private static void setDriver(WebDriver wDriver) {
        webDriver = wDriver;
    }

    private static void loadDriver() {
        driverFactory(EDGE);
    }

    private static void driverFactory(String type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                WebDriverRunner.setWebDriver(getDriver());
                getDriver().manage().window().maximize();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                WebDriverRunner.setWebDriver(getDriver());
                getDriver().manage().window().maximize();
                break;
            default:
                throw new IllegalStateException("Such driver is not supported");
        }
    }

    public static void closeDriver() {
        if (webDriver != null) {
            getDriver().close();
        }
    }

    public static boolean hasUrl() {
        return getDriver().getCurrentUrl() != null;
    }
}

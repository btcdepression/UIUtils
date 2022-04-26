import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UiTest {
    public static void openPage(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Oleksii_Kukhar1\\Desktop\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(7000);
        driver.quit();
    }
}

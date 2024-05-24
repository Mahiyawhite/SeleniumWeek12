package browserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        driver = new ChromeDriver();

        driver.get(baseUrl);

        String title = driver.getTitle();
        System.out.println(title);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    public void closeBrowser(){
        driver.quit();
    }
}

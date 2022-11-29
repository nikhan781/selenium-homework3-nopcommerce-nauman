package browserbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void browserSetup(String baserUrl, String browser) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser selection");
        }
        //Opening website in chosen browser
        driver.get(baserUrl);

        //Maximising window upon opening
        driver.manage().window().maximize();

        //Setting timeout for webpage to load completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closingTheBrowserBaseTest() {
        driver.close();
    }

}

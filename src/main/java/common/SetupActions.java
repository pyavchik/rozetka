package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER_AND_PLATFORM;
import static utils.constants.Constant.TimeoutVariables.IMPLICIT_WAIT;

public class SetupActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER_AND_PLATFORM) {
            case "CHROME_DOCKER":
                ChromeOptions opt = new ChromeOptions();
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "CHROME_MAC":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;

            case "CHROME_WINDOWS":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "FIREFOX_MAC":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;

            default: Assertions.fail("INCORRECT BROWSER NAME: " + BROWSER_AND_PLATFORM);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        return driver;
    }

}

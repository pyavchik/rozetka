package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.constants.Constant.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for navigating to a specific URL
     * @param url
     */
    public void goToUrl(String url){
        driver.get(url);
    }

    /**
     *
     * Wait for visibility element in DOM model
     * @param element
     * @return
     */
    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Wait for invisibility element in DOM model
     * @param element
     * @return
     */
    public WebElement waitInvisibilityOf(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

}

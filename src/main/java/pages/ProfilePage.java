package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#personal_information h1")
    private WebElement headerProfile;
    @FindBy(css = "#profile_signout")
    private WebElement userName;
    @FindBy(css = "#profile_signout")
    private WebElement buttonExit;
    @FindBy(xpath = "//div[@class='message-confirm-mail-i']")
    private WebElement textMessageEmailNotConfirmed;
    @FindBy(xpath = "//div[@class='pos-fix sprite-side message code1']")
    private WebElement textMessageEmailConfirmed;
    @FindBy(xpath = "(//div[@class='profile-info-l-i-text'])[2]")
    private WebElement textUserEmail;


    public void waitPageIsLoaded() {
        waitElementIsVisible(buttonExit);
    }

    public String getUserName() {
        isProfilePageDisplayed();
        isButtonExitDisplayed();
        return userName.getText();
    }

    private void isButtonExitDisplayed() {
        WebElement profileHeader = buttonExit;
        waitElementIsVisible(profileHeader);
    }

    private void isProfilePageDisplayed() {
        WebElement profileHeader = headerProfile;
        waitElementIsVisible(profileHeader);
    }

    public String emailNotConfirmedMessage() {
        return textMessageEmailNotConfirmed.getText();
    }

    public String getEmailConfirmedMessageText() {
        waitElementIsVisible(textMessageEmailConfirmed);
        return textMessageEmailConfirmed.getText();
    }

    public String getUserEmailText() {
        waitElementIsVisible(textUserEmail);
        return textUserEmail.getText();
    }
}

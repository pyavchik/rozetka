package pages;

import utils.dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.constants.Constant;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#signup_form > div:nth-child(1) > input")
    private WebElement inputName;
    @FindBy(css = "#signup_form > div:nth-child(2) > input")
    private WebElement inputEmail;
    @FindBy(css = "#signup_form > div:nth-child(3) > input")
    private WebElement inputPassword;
    @FindBy(css = "#signup_form > div.signup-submit > span > button")
    private WebElement buttonSubmit;
    @FindBy(css = "#profile_signout")
    private WebElement buttonExit;
    @FindBy(xpath = "//*[@id='signup_form']/div[1]/div[2]/div")
    private WebElement loader;

    public RegistrationPage openPage(){
        goToUrl(Constant.Urls.REGISTRATION_URL);
        return this;
    }

    public ProfilePage submitValidRegistrationForm() {
        submit();
        return new ProfilePage(driver);
    }

    public RegistrationPage submitRegistrationForm() {
        submit();
        return this;
    }

    public RegistrationPage fillUserRegistrationForm(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        return this;
    }

    private void setName(String name) {
        inputName.sendKeys(name);
    }

    private void setEmail(String email) {
        inputEmail.sendKeys(email);
    }

    private void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    private void submit() {
        buttonSubmit.submit();
    }
}

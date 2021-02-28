package tests.registration.positive;


import utils.dto.User;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.ProfilePage;
import pages.RegistrationPage;
import tests.base.BaseTest;
import utils.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.api.EmailApi.getVerificationLink;

public class RegistrationTest extends BaseTest {
    protected BasePage basePage = new BasePage(driver);
    protected RegistrationPage registrationPage = new RegistrationPage(driver);
    protected ProfilePage profilePage = new ProfilePage(driver);

    @Test
    public void checkIsRedirectToAuth() {
        User user = UserService.generateNewRandomUser();

        registrationPage.openPage()
                .fillUserRegistrationForm(user)
                .submitValidRegistrationForm()
                .waitPageIsLoaded();

        basePage.goToUrl(getVerificationLink(user.getEmail()));

        assertEquals(user.getEmail(), profilePage.getUserEmailText());
    }
}

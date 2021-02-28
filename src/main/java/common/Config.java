package common;

public class Config {


    public static String getBrowser() {

        String browser = System.getProperty("browser");

        if (browser.length() <= 0) {
            return "CHROME_MAC";
        }

        if (browser.equalsIgnoreCase("CHROME_MAC")) {
            return "CHROME_MAC";
        } else if (browser.equalsIgnoreCase("CHROME_DOCKER")) {
            return "CHROME_DOCKER";
        } else if (browser.equalsIgnoreCase("CHROME_WINDOWS")) {
            return "CHROME_WINDOWS";
        } else if (browser.equalsIgnoreCase("FIREFOX_MAC")) {
            return "FIREFOX_MAC";
        } else {
            return "CHROME_MAC";
        }

    }

    /**
     * CHROME_MAC
     * CHROME_DOCKER
     */
    public static final String BROWSER_AND_PLATFORM = getBrowser();

    /**
     * Clean browser cookies after each iteration
     */
    public static final boolean CLEAR_COOKIES = false;

    /**
     * Keep browser opened after each scenario
     */
    public static final boolean HOLD_BROWSER_OPEN = false;
}

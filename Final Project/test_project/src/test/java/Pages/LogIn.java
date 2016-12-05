package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class contains all fields to login some user
 *
 * @author Irina bogatko
 * @version 1.0
 * @since 01.12.2016
 */
public class LogIn {
    private WebDriver webDriver;
    private static final String LOGIN_PAGE = "http://localhost:8888/wp-login.php";
    private static final By USER_NAME = By.xpath(".//*[@id='user_login']");
    private static final By PASSWORD = By.xpath(".//*[@id='user_pass']");
    private static final By LOGIN_BUTTON = By.xpath(".//*[@id='wp-submit']");
    private static final By LOG_OUT_BUTTON = By.xpath("//a[text()='Log out']");
    private static final By ERROR_MESSAGE = By.xpath(".//*[@id='login_error']");

    /**
     * Create new logIn
     *
     * @param webDriver current web driver
     */
    public LogIn(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Open logIn page
     *
     * @return new LogIn page
     */
    public LogIn open() {
        webDriver.get(LOGIN_PAGE);
        return new LogIn(webDriver);
    }

    /**
     * Find field for user name and add name of user
     *
     * @param enterUserName name of user
     */
    private void setUserName(String enterUserName) {
        webDriver.findElement(USER_NAME).sendKeys(enterUserName);
    }

    /**
     * Find field for password and add password in field
     *
     * @param enterPassword password of user
     */
    private void setPassword(String enterPassword) {
        webDriver.findElement(PASSWORD).sendKeys(enterPassword);
    }

    /**
     * Find login button and click it
     */
    private void clickLoginButton() {
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    /**
     * Find error message on login page
     *
     * @return true, if error message was found
     */
    public boolean findErrorMessage() {
        try {
            webDriver.findElement(ERROR_MESSAGE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Find logOut button and click it
     *
     * @return new homePage
     */
    public HomePage logOut() {
        webDriver.findElement(LOG_OUT_BUTTON).click();
        return new HomePage(webDriver);
    }

    /**
     * Login new user and submit it
     *
     * @param enterUserName name of user
     * @param enterPassword password of user
     * @return new homePage with entered name and password of user
     */
    public HomePage logIn(String enterUserName, String enterPassword) {
        this.setUserName(enterUserName);
        this.setPassword(enterPassword);
        this.clickLoginButton();
        return new HomePage(webDriver);
    }
}

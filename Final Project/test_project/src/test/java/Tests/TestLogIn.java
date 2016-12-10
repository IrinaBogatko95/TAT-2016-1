package Tests;

import Pages.HomePage;
import Pages.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class TestLogIn {
    private WebDriver webDriver;
    private LogIn objLogin;
    private HomePage objHomePage;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", ".//geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        webDriver.close();
    }

    @Test (alwaysRun = true)
    public void positiveLogInAsAdmin() throws Exception {
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        objLogin = new LogIn(webDriver).open();
        objLogin.logIn("IrinaBogatko", "159753");
        assertFalse(objLogin.findErrorMessage());
        objHomePage = new HomePage(webDriver);
        objHomePage.open();
        objLogin.logOut();
    }

    @Test (alwaysRun = true)
    public void positiveLogInAsUser() throws Exception {
        objLogin = new LogIn(webDriver).open();
        objLogin.logIn("User", "123");
        assertFalse(objLogin.findErrorMessage());
        objHomePage = new HomePage(webDriver);
        objHomePage.open();
        objLogin.logOut();
    }

    @Test (alwaysRun = true)
    public void negativeLogInAsAdmin() {
        objLogin = new LogIn(webDriver).open();
        objLogin.logIn("IvanIvanov", "111111");
        webDriver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(objLogin.findErrorMessage());
    }

    @Test (alwaysRun = true)
    public void negativeLogInAsUser() throws Exception {
        objLogin = new LogIn(webDriver).open();
        objLogin.logIn("Alex", "1111");
        webDriver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(objLogin.findErrorMessage());
    }
}

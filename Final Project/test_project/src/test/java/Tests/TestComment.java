package Tests;

import Pages.Comment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestComment {
    private WebDriver webDriver;
    private Comment objComment;

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

    @Test
    public void positiveTestLeaveComment() throws Exception {
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        objComment = new Comment(webDriver).openSomeNews();
        objComment.leaveComment("Hello dear friend!", "Irina", "irkabog95@mail.ru", "google.com");
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertFalse(objComment.failedComment());
    }

    @Test
    public void negativeTestLeaveComment() throws Exception {
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        objComment = new Comment(webDriver).openSomeNews();
        objComment.leaveComment("Some message", "Ivan", "", "vk.com");
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        Assert.assertTrue(objComment.failedComment());

    }
}

package Tests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class TestHomePage {
    private WebDriver webDriver;
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
    public void testClickAllLinks() throws Exception {
        objHomePage = new HomePage(webDriver).open();
        List<WebElement> tagsList = objHomePage.findAllLinksOnHomePage();
        for (WebElement tagElement : tagsList) {
            String url = tagElement.getAttribute("href");
            assertFalse(objHomePage.isLinkBroken(url));
        }
    }

    @Test (alwaysRun = true)
    public void testPositiveSearch() {
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        objHomePage = new HomePage(webDriver).open();
        objHomePage.search("Some news");
        assertFalse(objHomePage.searchError());
    }

    @Test (alwaysRun = true)
    public void testNegativeSearch() {
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        objHomePage = new HomePage(webDriver).open();
        objHomePage.search("ttt");
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(objHomePage.searchError());
    }
}

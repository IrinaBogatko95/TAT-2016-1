package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Home page of localhost
 *
 * @author Irina bogatko
 * @version 1.0
 * @since 01.12.2016
 */
public class HomePage {
    private WebDriver webDriver;
    private static final String HOME_PAGE = "http://localhost:8888/";
    private By SEARCH_FIELD = By.xpath(".//*[@id='search-2']/form/label/input");

    /**
     * Create new HomePage
     *
     * @param webDriver current web driver
     */
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Open new current page
     *
     * @return new opened home page
     */
    public HomePage open() {
        webDriver.get(HOME_PAGE);
        return new HomePage(webDriver);
    }

    /**
     * Find search field and set some text
     *
     * @param text text, which need to enter in field
     */
    public void setTextToSearch(String text) {
        webDriver.findElement(SEARCH_FIELD).sendKeys(text);
    }

    /**
     * Find search field and submit entered text
     */
    public void submitSearch() {
        webDriver.findElement(SEARCH_FIELD).submit();
    }

    /**
     * Set new text in search field and find it
     *
     * @param text text, which need to enter in field
     * @return new HomePage with searched text
     */
    public HomePage search(String text) {
        this.setTextToSearch(text);
        this.submitSearch();
        return new HomePage(webDriver);
    }

    /**
     * Find error from search request
     *
     * @return true if was found error
     */
    public boolean searchError() {
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        boolean error = webDriver.getPageSource().contains("Sorry, but nothing matched your search terms.");
        return error;
    }

    /**
     * Find all links on HomePage and set it to list
     *
     * @return list of links
     */
    public List<WebElement> findAllLinksOnHomePage() {
        List<WebElement> elementList = new ArrayList<>();
        elementList = webDriver.findElements(By.tagName("a"));
        elementList.addAll(webDriver.findElements(By.tagName("img")));
        List<WebElement> finalList = new ArrayList<>();
        for (WebElement element : elementList) {
            if (element.getAttribute("href") != null) {
                finalList.add(element);
            }
        }
        return finalList;
    }

    /**
     * Find broken links
     *
     * @param linkUrl url of link
     * @return true, if broken link was found
     */
    public boolean isLinkBroken(String linkUrl) throws Exception {
        URL url = new URL(linkUrl);
        HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
        httpURLConnect.setConnectTimeout(3000);
        httpURLConnect.connect();
        if (httpURLConnect.getResponseCode() == 200) {
            return false;
        }
        if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
            return true;
        }
        return true;
    }
}

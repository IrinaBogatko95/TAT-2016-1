package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Class contains all fields to create comment
 *
 * @author Irina bogatko
 * @version 1.0
 * @since 01.12.2016
 */
public class Comment {
    private WebDriver webDriver;
    private static final String SOME_NEWS_URL = "http://localhost:8888/?p=4";
    private static final By COMMENT = By.id("comment");
    private static final By NAME = By.id("author");
    private static final By E_MAIL = By.id("email");
    private static final By WEBSITE = By.id("url");
    private static final By POST_COMMENT_BUTTON = By.id("submit");

    /**
     * Create new Comment
     *
     * @param webDriver current web driver
     */
    public Comment(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Open page with comment-field
     *
     * @return created comment
     */
    public Comment openSomeNews() {
        webDriver.get(SOME_NEWS_URL);
        return new Comment(webDriver);
    }

    /**
     * Find field for comment and add some text in there
     *
     * @param comment text, which needs to add
     */
    private void setComment(String comment) {
        webDriver.findElement(COMMENT).sendKeys(comment);
    }

    /**
     * Find field for name and add name of author of comment in there
     *
     * @param name name of author
     */
    private void setName(String name) {
        webDriver.findElement(NAME).sendKeys(name);
    }

    /**
     * Find field for e-mail and add e-mail of author of comment in there
     *
     * @param eMail e-mail of author
     */
    private void setEmail(String eMail) {
        webDriver.findElement(E_MAIL).sendKeys(eMail);
    }

    /**
     * Find field for website and add some website in there
     *
     * @param website website of author
     */
    private void setWebsite(String website) {
        webDriver.findElement(WEBSITE).sendKeys(website);
    }

    /**
     * Find submit button and click it
     */
    private void clickSubmitButton() {
        webDriver.findElement(POST_COMMENT_BUTTON).click();
    }

    /**
     * Find failed comment
     *
     * @return true, if failed comment was found
     */
    public boolean failedComment() {
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        boolean title = webDriver.getTitle().contains("Comment Submission Failure");
        return title;
    }

    /**
     * Leave new comment and submit it
     *
     * @param comment text to need to comment
     * @param name    name of author
     * @param eMail   e-mail of author
     * @param website website of author
     * @return new comment with entered values
     */
    public Comment leaveComment(String comment, String name, String eMail, String website) {
        this.setComment(comment);
        this.setName(name);
        this.setEmail(eMail);
        this.setWebsite(website);
        this.clickSubmitButton();
        return new Comment(webDriver);
    }
}

package qflow.acceptance;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Collection;
import java.util.List;

public class PageDriver {

    private final WebDriver webDriver;

    private final String baseUrl;

    public PageDriver(String baseUrl, WebDriver webDriver) {
        this.baseUrl = baseUrl;
        this.webDriver = webDriver;
    }

    public void close() {
        webDriver.close();
        webDriver.quit();
    }

    public void open(String subUrl) {
        webDriver.get(baseUrl + subUrl);
    }

    public void enterText(String elementId, String text) {
        WebElement element = webDriver.findElement(By.id(elementId));
        element.clear();
        element.sendKeys(text);
    }

    public void clickSubmit() {
        webDriver.findElement(By.cssSelector("button[type=submit]")).click();
    }

    public List<WebElement> findElementsByClassName(String className) {
        return webDriver.findElements(By.className(className));
    }

    public void clinkOnLinkWithVisibleText(final String text) {
        Collection<WebElement> links = webDriver.findElements(By.cssSelector("a"));
        Collection<WebElement> linksWithText = Collections2.filter(links, new Predicate<WebElement>() {
            @Override
            public boolean apply(WebElement input) {
                return input.getText().equals(text);
            }
        });
        if (linksWithText.size() > 1) {
            throw new IllegalArgumentException("More than one link found with text " + text);
        }
        linksWithText.iterator().next().click();
    }

    public void clickOnElement(String id) {
        webDriver.findElement(By.id(id)).click();
    }
}

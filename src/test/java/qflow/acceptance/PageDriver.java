package qflow.acceptance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

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

    private WebElement findElement(String id) {
        return webDriver.findElement(By.id(id));
    }

    public List<WebElement> findElementsByClassName(String className) {
        return webDriver.findElements(By.className(className));
    }
}

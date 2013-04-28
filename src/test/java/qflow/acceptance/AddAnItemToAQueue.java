package qflow.acceptance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import qflow.Application;

public class AddAnItemToAQueue {

    public static final String QUEUE_NAME = "Test Queue";

    public static final String ITEM_DESCRIPTION = "An item";

    private ApplicationDriver driver;

    private Application application;

    @Before
    public void setUp() throws Exception {
        int port = 8081;
        //driver = new ApplicationDriver("http://localhost:" + port, new HtmlUnitDriver());
        driver = new ApplicationDriver("http://localhost:" + port, new FirefoxDriver());
        application = new Application(port);
        application.start();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        application.stop();
    }

    @Test
    public void addAnItemToAQueue() throws Exception {
        driver.createQueue(QUEUE_NAME);
        driver.addItemToQueue(QUEUE_NAME, ITEM_DESCRIPTION);

        driver.showsItemInQueue(QUEUE_NAME, ITEM_DESCRIPTION);
    }
}

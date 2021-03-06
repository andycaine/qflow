package qflow.acceptance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import qflow.Application;

public class CreateAQueue {

    public static final String QUEUE_NAME = "Test Queue";

    private ApplicationDriver driver;

    private Application application;

    @Before
    public void setUp() throws Exception {
        int port = 8081;
        driver = new ApplicationDriver("http://localhost:" + port, new HtmlUnitDriver());
        application = new Application(port);
        application.start();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        application.stop();
    }

    @Test
    public void canCreateAQueue() throws Exception {
        driver.createQueue(QUEUE_NAME);
        driver.showsQueue(QUEUE_NAME);
    }
}

package qflow.acceptance;

import org.openqa.selenium.WebDriver;

public class ApplicationDriver {

    private final PageDriver pageDriver;

    private final CreateQueuePageDriver createQueuePageDriver;

    private final ListQueuesPageDriver listQueuesPageDriver;

    public ApplicationDriver(String url, WebDriver webDriver) {
        this.pageDriver = new PageDriver(url, webDriver);
        createQueuePageDriver = new CreateQueuePageDriver(pageDriver);
        listQueuesPageDriver = new ListQueuesPageDriver(pageDriver);
    }

    public void close() {
        pageDriver.close();
    }

    public void createQueue(String name) {
        createQueuePageDriver.createQueue(name);
    }

    public void showsQueue(String name) {
        listQueuesPageDriver.showsQueue(name);
    }
}

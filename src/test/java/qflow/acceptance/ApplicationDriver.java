package qflow.acceptance;

import org.openqa.selenium.WebDriver;

import javax.swing.*;

import static org.junit.Assert.fail;

public class ApplicationDriver {

    private final PageDriver pageDriver;

    private final CreateQueuePageDriver createQueuePageDriver;

    private final ListQueuesPageDriver listQueuesPageDriver;

    private AddItemPageDriver addItemPageDriver;

    private ListItemsPageDriver listItemsPageDriver;

    public ApplicationDriver(String url, WebDriver webDriver) {
        this.pageDriver = new PageDriver(url, webDriver);
        createQueuePageDriver = new CreateQueuePageDriver(pageDriver);
        listQueuesPageDriver = new ListQueuesPageDriver(pageDriver);
        addItemPageDriver = new AddItemPageDriver(pageDriver);
        listItemsPageDriver = new ListItemsPageDriver(pageDriver);
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

    public void addItemToQueue(String queueName, String itemDescription) {
        addItemPageDriver.addItem(queueName, itemDescription);
    }

    public void showsItemInQueue(String queueName, String itemDescription) {
        listItemsPageDriver.showsItem(queueName, itemDescription);
    }
}

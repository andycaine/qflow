package qflow.acceptance;

public class AddItemPageDriver {

    private final PageDriver pageDriver;

    public AddItemPageDriver(PageDriver pageDriver) {
        this.pageDriver = pageDriver;
    }

    public void addItem(String queueName, String itemDescription) {
        pageDriver.open("/queues/");
        pageDriver.clinkOnLinkWithVisibleText(queueName);
        pageDriver.clickOnElement("new-item-btn");
        pageDriver.enterText("description", itemDescription);
        pageDriver.clickSubmit();
    }
}

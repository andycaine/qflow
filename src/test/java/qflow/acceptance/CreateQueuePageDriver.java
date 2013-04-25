package qflow.acceptance;

public class CreateQueuePageDriver {

    private final PageDriver pageDriver;

    public CreateQueuePageDriver(PageDriver pageDriver) {
        this.pageDriver = pageDriver;
    }

    public void createQueue(String name) {
        pageDriver.open("/queues/new");
        pageDriver.enterText("name", name);
        pageDriver.clickSubmit();
    }

}

package qflow.acceptance;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class ListQueuesPageDriver {

    private PageDriver pageDriver;

    public ListQueuesPageDriver(PageDriver pageDriver) {
        this.pageDriver = pageDriver;
    }

    public void showsQueue(String name) {
        pageDriver.open("/queues");
        assertThat(queues(), hasAQueueCalled(name));
    }

    private Matcher<Iterable<? super WebElement>> hasAQueueCalled(String name) {
        return hasItem(aQueueCalled(name));
    }

    private Matcher<? super WebElement> aQueueCalled(final String name) {
        return new TypeSafeMatcher<WebElement>() {
            @Override
            protected boolean matchesSafely(WebElement item) {
                return name.equals(item.findElement(By.className("name")).getText());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("a web element showing a queue called ").appendValue(name);
            }
        };
    }

    private Iterable<WebElement> queues() {
        return pageDriver.findElementsByClassName("queue");
    }
}

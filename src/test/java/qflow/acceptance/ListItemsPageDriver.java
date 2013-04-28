package qflow.acceptance;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class ListItemsPageDriver {

    private PageDriver pageDriver;

    public ListItemsPageDriver(PageDriver pageDriver) {
        this.pageDriver = pageDriver;
    }

    public void showsItem(String queueName, String itemDescription) {
        pageDriver.open("/queues");
        pageDriver.clinkOnLinkWithVisibleText(queueName);
        System.out.println(items());
        assertThat(items(), hasAnItemWithDescription(itemDescription));
    }

    private Matcher<Iterable<? super ItemTableRow>> hasAnItemWithDescription(String description) {
        return hasItem(anItemWithDescription(description));
    }

    private Matcher<? super ItemTableRow> anItemWithDescription(final String description) {
        return new TypeSafeMatcher<ItemTableRow>() {
            @Override
            protected boolean matchesSafely(ItemTableRow item) {
                return description.equals(item.description());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("a web element showing an item with description ").appendValue(description);
            }
        };
    }

    private Iterable<ItemTableRow> items() {
        return Collections2.transform(pageDriver.findElementsByClassName("item"), new Function<WebElement, ItemTableRow>() {
            @Override
            public ItemTableRow apply(WebElement input) {
                return new ItemTableRow(input);
            }
        });
    }

    private static class ItemTableRow {

        private final WebElement webElement;

        private ItemTableRow(WebElement webElement) {
            this.webElement = webElement;
        }

        private String description() {
            return webElement.findElement(By.className("description")).getText();
        }

        @Override
        public String toString() {
            return "A table row for an item with description <" + description() + ">";
        }
    }
}

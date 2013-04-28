package qflow;

import java.util.ArrayList;
import java.util.List;

public class Queue extends Entity {

    private String name;

    private List<Item> items = new ArrayList<Item>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}

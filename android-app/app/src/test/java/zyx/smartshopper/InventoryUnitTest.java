package zyx.smartshopper;

import org.junit.Test;

import zyx.smartshopper.storeData.Item;

import static org.junit.Assert.*;

public class InventoryUnitTest {

    @Test
    public void createItemTest01() {
        Item testItem = new Item(0);
        assertEquals("Unknown Item", testItem.getName());
        assertEquals("No Description", testItem.getDescription());
        assertEquals(0, testItem.getPrice(), 0);
    }

    @Test
    public void createItemTest02() {
        Item testItem = new Item(22, "Pickachu Hat", "Its yellow and scrubby", 99.99);
        assertEquals("Pickachu Hat", testItem.getName());
        assertEquals("Its yellow and scrubby", testItem.getDescription());
        assertEquals(99.99, testItem.getPrice(), 0);
    }
}

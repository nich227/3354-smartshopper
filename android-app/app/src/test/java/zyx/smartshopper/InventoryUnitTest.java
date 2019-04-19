package zyx.smartshopper;

import org.junit.Test;

import zyx.smartshopper.storeData.Item;
import zyx.smartshopper.storeData.Store;

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

    @Test
    public void addItemToInventoryTest01() {
        Item testItem = new Item(20, "Suave Shampoo", "Blue shampoo bottle", 7.99);
        Store testStore = new Store(1, "Walmart", null);
        testStore.addItemToInventory(testItem);
        assertTrue(testStore.itemInInventory(testItem));
    }

    @Test
    public void deleteItemTest01() {
        Item testItem = new Item(20, "Suave Shampoo", "Blue shampoo bottle", 7.99);
        Store testStore = new Store(1, "Walmart", null);
        testStore.addItemToInventory(testItem);
        testStore.deleteItemFromInventory(testItem);
        assertFalse(testStore.itemInInventory(testItem));
    }

    @Test
    public void inventoryOperationsTest01() {
        Store testStore = new Store(1, "Walmart", null);
        Item testItem1 = new Item(20, "Suave Shampoo", "Blue shampoo bottle", 7.99);
        Item testItem2 = new Item(20, "Suave Shampoo", "Blue shampoo bottle", 7.99);

        testStore.addItemToInventory(testItem1);
        testStore.addItemToInventory(testItem2);

        assertTrue(testStore.itemInInventory(testItem1));
        assertEquals(testStore.getItemCountInInventory(testItem1), 2);
        testStore.removeItemFromInventory(testItem2);
        assertEquals(testStore.getItemCountInInventory(testItem1), 1);
        testStore.removeItemFromInventory(testItem2);
        assertEquals(testStore.getItemCountInInventory(testItem1), 0);
        testStore.deleteItemFromInventory(testItem2);
        assertFalse(testStore.itemInInventory(testItem2));
    }

    @Test
    public void inventoryOperationsTest02() {
        Store testStore = new Store(1, "Walmart", null);
        Item testItem1 = new Item(20, "Suave Shampoo", "Blue shampoo bottle", 7.99);
        Item testItem2 = new Item(20, "Suave Shampoo", "Blue shampoo bottle", 7.99);
        Item testItem3 = new Item(21, "New York Steak Strip", "Nice and delicious", 7.99);
        Item testItem4 = new Item(22, "Pickachu Hat", "Its yellow and scrubby", 99.99);

        testStore.addItemToInventory(testItem1);
        testStore.addItemToInventory(testItem2);
        testStore.addItemToInventory(testItem3);
        testStore.addItemToInventory(testItem4);

        testStore.removeItemFromInventory(testItem1);
        assertEquals(testStore.getItemCountInInventory(testItem1), 1);
        testStore.removeItemFromInventory(testItem3);
        testStore.addItemToInventory(testItem3);
        assertEquals(testStore.getItemCountInInventory(testItem3), 1);
    }

}

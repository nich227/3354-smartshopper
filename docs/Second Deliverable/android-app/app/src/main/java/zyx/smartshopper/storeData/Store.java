package zyx.smartshopper.storeData;

import java.util.HashMap;

public class Store {
    private int id;
    private String name;
    private double[] geoCoordinates;
    private HashMap<Integer, Item> inventory;

    public Store() {
        this(0, "Unknown Store", null);
    }
    public Store(int id, String name, double[] geoCoordinates) {
        this.id = id;
        this.name = name;
        this.geoCoordinates = geoCoordinates;
        inventory = new HashMap<>();
    }

    public void updateInventory(HashMap<Integer, Item> newInventory) {
        this.inventory = newInventory;
    }
    public void addItemToInventory(Item newItem) {
        if(!itemInInventory(newItem))
            this.inventory.put(newItem.getId(), newItem);
        else if(this.inventory.get(newItem.getId()) != null)
            this.inventory.get(newItem.getId()).incrementCount();
    }
    public void removeItemFromInventory(Item item) {
        if(itemInInventory(item))
            this.inventory.get(item.getId()).decrementCount();
    }
    public void deleteItemFromInventory(Item item) {
        this.inventory.remove(item.getId());
    }
    public boolean itemInInventory(Item item) {
        return inventory.containsKey(item.getId());
    }
    public int getItemCountInInventory(Item item) {
        return inventory.get(item.getId()).getCount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(double[] geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }
}

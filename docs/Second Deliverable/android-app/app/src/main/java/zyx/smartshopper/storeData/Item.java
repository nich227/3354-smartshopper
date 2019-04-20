package zyx.smartshopper.storeData;

public class Item {
    private int id;
    private String name;
    private String description;
    private double price;
    private int count;

    public Item(int id) {
        this(id, "Unknown Item", "No Description", 0.0);
    }

    public Item(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }
    public void decrementCount() {
        count--;
    }
}

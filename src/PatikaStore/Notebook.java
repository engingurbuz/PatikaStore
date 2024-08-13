package PatikaStore;

public class Notebook extends Product {
    private int ram;
    private int storage;
    private double screenSize;

    public Notebook(int id, double price, double discount, int stock, String name, Brand brand,
                    int ram, int storage, double screenSize) {
        super(id, price, discount, stock, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    @Override
    public String getProductDetails() {
        return String.format("ID: %d, Name: %s, Price: %.2f, Brand: %s, RAM: %dGB, Storage: %dGB, Screen: %.1f\"",
                getId(), getName(), getPrice(), getBrand().getName(), ram, storage, screenSize);
    }
}

package PatikaStore;

public class MobilePhone extends Product {
    private int memory;
    private double screenSize;
    private int battery;
    private int ram;
    private String color;

    public MobilePhone(int id, double price, double discount, int stock, String name, Brand brand,
                       int memory, double screenSize, int battery, int ram, String color) {
        super(id, price, discount, stock, name, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    @Override
    public String getProductDetails() {
        return String.format("ID: %d, Name: %s, Price: %.2f, Brand: %s, Memory: %dGB, Screen: %.1f\", Battery: %dmAh, RAM: %dGB, Color: %s",
                getId(), getName(), getPrice(), getBrand().getName(), memory, screenSize, battery, ram, color);
    }
}

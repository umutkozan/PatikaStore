package PatikaStore;

public class Notebook extends Product {
    private int ram;
    private String storage;
    private double screenSize;

    public Notebook(double price, double discountRate, int stock, String name, Brand brand,
                    int ram, String storage, double screenSize) {
        super(price, discountRate, stock, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    @Override
    public void printDetails() {
        System.out.format("Notebook [id=%d, name=%s, brand=%s, price=%.2f, discount=%.2f, stock=%d, ram=%d, storage=%s, screenSize=%.1f]\n",
                getId(), getName(), getBrand().getName(), getPrice(), getDiscountRate(), getStock(),
                ram, storage, screenSize);
    }
}

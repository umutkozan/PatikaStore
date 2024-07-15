package PatikaStore;

public abstract class Product {
    private int id; // Ürünün benzersiz numarası
    private double price; // Ürünün fiyatı
    private double discountRate; // Ürünün indirim oranı
    private int stock; // Ürünün stok miktarı
    private String name; // Ürünün adı
    private Brand brand; // Ürünün markası
    private static int idCounter = 1; // Ürün ID'lerini takip eden sayaç

    // Ürün oluşturucu metodu
    public Product(double price, double discountRate, int stock, String name, Brand brand) {
        this.id = idCounter++;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }

    // Ürünün ID'sini döndüren metot
    public int getId() {
        return id;
    }

    // Ürünün fiyatını döndüren metot
    public double getPrice() {
        return price;
    }

    // Ürünün indirim oranını döndüren metot
    public double getDiscountRate() {
        return discountRate;
    }

    // Ürünün stok miktarını döndüren metot
    public int getStock() {
        return stock;
    }

    // Ürünün adını döndüren metot
    public String getName() {
        return name;
    }

    // Ürünün markasını döndüren metot
    public Brand getBrand() {
        return brand;
    }

    // Ürün detaylarını yazdıran soyut metot (her alt sınıfta implemente edilecek)
    public abstract void printDetails();
}
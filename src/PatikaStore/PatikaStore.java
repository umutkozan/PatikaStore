package PatikaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatikaStore {
    private List<Product> products = new ArrayList<>(); // Mağazadaki ürünlerin listesi

    // Ürün ekleme metodu
    public void addProduct(Product product) {
        products.add(product);
    }

    // Kategoriye göre ürünleri listeleme metodu
    public void listProductsByCategory(Class<?> category) {
        for (Product product : products) {
            if (category.isInstance(product)) {
                product.printDetails();
            }
        }
    }

    // Ürün ID'sine göre ürünü silme metodu
    public void deleteProductById(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    // Markaya göre ürünleri listeleme metodu
    public void listProductsByBrand(String brandName) {
        for (Product product : products) {
            if (product.getBrand().getName().equalsIgnoreCase(brandName)) {
                product.printDetails();
            }
        }
    }

    // Statik olarak marka bilgilerini ekleyen metot
    public void initializeBrands() {
        new Brand("Samsung");
        new Brand("Lenovo");
        new Brand("Apple");
        new Brand("Huawei");
        new Brand("Casper");
        new Brand("Asus");
        new Brand("HP");
        new Brand("Xiaomi");
        new Brand("Monster");
    }

    // Markaları alfabetik sırayla listeleyen metot
    public void listBrands() {
        for (Brand brand : Brand.getBrands()) {
            System.out.println("Brand ID: " + brand.getId() + ", Name: " + brand.getName());
        }
    }

    // Programın ana metodu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatikaStore store = new PatikaStore();
        store.initializeBrands();

        boolean running = true;
        while (running) {
            System.out.println("\nPatikaStore Yönetim Paneli");
            System.out.println("1. Markaları Listele");
            System.out.println("2. Kategoriye Göre Ürün Listele");
            System.out.println("3. Ürün Ekle");
            System.out.println("4. Ürün Sil");
            System.out.println("5. Markaya Göre Ürün Listele");
            System.out.println("6. Çıkış");
            System.out.print("Bir seçenek seçin: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    store.listBrands();
                    break;
                case 2:
                    System.out.print("Kategori girin (Phone/Notebook): ");
                    String category = scanner.next();
                    if (category.equalsIgnoreCase("Phone")) {
                        store.listProductsByCategory(Phone.class);
                    } else if (category.equalsIgnoreCase("Notebook")) {
                        store.listProductsByCategory(Notebook.class);
                    } else {
                        System.out.println("Geçersiz kategori.");
                    }
                    break;
                case 3:
                    System.out.print("Ürün türünü girin (Phone/Notebook): ");
                    String type = scanner.next();
                    if (type.equalsIgnoreCase("Phone")) {
                        System.out.print("Adını girin: ");
                        String name = scanner.next();
                        System.out.print("Markasını girin: ");
                        String brandName = scanner.next();
                        Brand brand = Brand.getBrandByName(brandName);
                        if (brand == null) {
                            System.out.println("Geçersiz marka.");
                            break;
                        }
                        System.out.print("Fiyatını girin: ");
                        double price = scanner.nextDouble();
                        System.out.print("İndirim oranını girin: ");
                        double discountRate = scanner.nextDouble();
                        System.out.print("Stok miktarını girin: ");
                        int stock = scanner.nextInt();
                        System.out.print("Hafızasını girin: ");
                        String memory = scanner.next();
                        System.out.print("Ekran boyutunu girin: ");
                        double screenSize = scanner.nextDouble();
                        System.out.print("Pil gücünü girin: ");
                        int battery = scanner.nextInt();
                        System.out.print("RAM miktarını girin: ");
                        int ram = scanner.nextInt();
                        System.out.print("Rengini girin: ");
                        String color = scanner.next();
                        Phone phone = new Phone(price, discountRate, stock, name, brand, memory, screenSize, battery, ram, color);
                        store.addProduct(phone);
                    } else if (type.equalsIgnoreCase("Notebook")) {
                        System.out.print("Adını girin: ");
                        String name = scanner.next();
                        System.out.print("Markasını girin: ");
                        String brandName = scanner.next();
                        Brand brand = Brand.getBrandByName(brandName);
                        if (brand == null) {
                            System.out.println("Geçersiz marka.");
                            break;
                        }
                        System.out.print("Fiyatını girin: ");
                        double price = scanner.nextDouble();
                        System.out.print("İndirim oranını girin: ");
                        double discountRate = scanner.nextDouble();
                        System.out.print("Stok miktarını girin: ");
                        int stock = scanner.nextInt();
                        System.out.print("RAM miktarını girin: ");
                        int ram = scanner.nextInt();
                        System.out.print("Depolama türünü girin: ");
                        String storage = scanner.next();
                        System.out.print("Ekran boyutunu girin: ");
                        double screenSize = scanner.nextDouble();
                        Notebook notebook = new Notebook(price, discountRate, stock, name, brand, ram, storage, screenSize);
                        store.addProduct(notebook);
                    } else {
                        System.out.println("Geçersiz ürün türü.");
                    }
                    break;
                case 4:
                    System.out.print("Silinecek ürün ID'sini girin: ");
                    int id = scanner.nextInt();
                    store.deleteProductById(id);
                    break;
                case 5:
                    System.out.print("Filtrelemek istediğiniz markayı girin: ");
                    String brandName = scanner.next();
                    store.listProductsByBrand(brandName);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçenek.");
            }
        }

        scanner.close();
    }
}
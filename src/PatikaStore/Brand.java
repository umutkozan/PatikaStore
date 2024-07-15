package PatikaStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brand implements Comparable<Brand> {
    // Marka bilgilerini tutan sınıf
        private int id; // Markanın benzersiz numarası
        private String name; // Markanın adı
        private static List<Brand> brands = new ArrayList<>(); // Tüm markaların listesi
        private static int idCounter = 1; // Marka ID'lerini takip eden sayaç

        // Marka oluşturucu metodu
        public Brand(String name) {
            this.id = idCounter++;
            this.name = name;
            brands.add(this);
        }

        // Markanın ID'sini döndüren metot
        public int getId() {
            return id;
        }

        // Markanın adını döndüren metot
        public String getName() {
            return name;
        }

        // Tüm markaları döndüren metot (alfabetik sıralı)
        public static List<Brand> getBrands() {
            Collections.sort(brands);
            return brands;
        }

        // Markaları alfabetik sıralamak için kullanılan metot
        @Override
        public int compareTo(Brand other) {
            return this.name.compareTo(other.name);
        }

        // Markanın adını kullanarak markayı bulan metot
        public static Brand getBrandByName(String name) {
            for (Brand brand : brands) {
                if (brand.getName().equalsIgnoreCase(name)) {
                    return brand;
                }
            }
            return null;
        }
    }

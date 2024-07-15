package PatikaStore;

public class Phone  extends Product{
        private String memory;
        private double screenSize;
        private int battery;
        private int ram;
        private String color;

        public Phone(double price, double discountRate, int stock, String name, Brand brand,
                     String memory, double screenSize, int battery, int ram, String color) {
            super(price, discountRate, stock, name, brand);
            this.memory = memory;
            this.screenSize = screenSize;
            this.battery = battery;
            this.ram = ram;
            this.color = color;
        }

        @Override
        public void printDetails() {
            System.out.format("Phone [id=%d, name=%s, brand=%s, price=%.2f, discount=%.2f, stock=%d, memory=%s, screenSize=%.1f, battery=%d, ram=%d, color=%s]\n",
                    getId(), getName(), getBrand().getName(), getPrice(), getDiscountRate(), getStock(),
                    memory, screenSize, battery, ram, color);
        }
    }


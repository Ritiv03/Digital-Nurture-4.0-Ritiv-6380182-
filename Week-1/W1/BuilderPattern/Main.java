package BuilderPattern;

class Computer {
    // Required parameters
    private String CPU;
    private String RAM;
    private String Storage;


    // ✅ Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    // ✅ Static Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String Storage;

        public Builder(String CPU, String RAM, String Storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.Storage = Storage;
        }


        // ✅ build() method
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage +
                "]";
    }
}


public class Main {
    public static void main(String[] args) {
        // Configuration 1: Gaming PC
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB", "1TB SSD")
                .build();

        // Configuration 2: Office PC
        Computer officePC = new Computer.Builder("Intel i5", "8GB", "512GB SSD")
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}

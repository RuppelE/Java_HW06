public class Laptop {
    private String model;
    private int ramSize;
    private int storageSize;
    private String operatingSystem;

    public Laptop(String model, int ramSize, int storageSize, String operatingSystem) {
        this.model = model;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
    }

    public String getModel() {
        return model;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}

package inventory_service.model;

public class Inventory {

    private Long productId;
    private String productName;
    private int availableQuantity;
    private boolean available;

    public Inventory() {
    }

    public Inventory(Long productId, String productName,
                     int availableQuantity, boolean available) {
        this.productId = productId;
        this.productName = productName;
        this.availableQuantity = availableQuantity;
        this.available = available;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
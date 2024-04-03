package az.edu.ada.adazon.product;

public class PurchaseDTO {
    private Long userId;
    private String username;
    private String email;
    private String productName;
    private String description;
    private double price;
    private Long productId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public PurchaseDTO(Long userId, String username, String email, String productName, String description, double price, Long productId) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productId = productId;
    }
}

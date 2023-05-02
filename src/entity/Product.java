package entity;

public class Product {
    private int id;
    private String productName;
    private ProductType productType;
    private int productFee;
    private ProductFeatures productFeatures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getProductFee() {
        return productFee;
    }

    public void setProductFee(int productFee) {
        this.productFee = productFee;
    }

    public ProductFeatures getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(ProductFeatures productFeatures) {
        this.productFeatures = productFeatures;
    }
}

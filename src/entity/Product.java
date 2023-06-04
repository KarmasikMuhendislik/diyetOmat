package entity;

public class Product {
    private int id;
    private String productName;
    private int productType;
    private int productFee;
    private int productFeatures;
    private int productAmount;

    public Product(String productName, int productType, int productFee, int productFeatures) {
        this.setProductName(productName);
        this.setProductType(productType);
        this.setProductFee(productFee);
        this.setProductFeatures(productFeatures);
    }
    public Product(){

    }

    public Product(String productName, int productFee) {
        this.setProductName(productName);
        this.setProductFee(productFee);
    }


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

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProductFee() {
        return productFee;
    }

    public void setProductFee(int productFee) {
        this.productFee = productFee;
    }

    public int getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(int productFeatures) {
        this.productFeatures = productFeatures;
    }
}

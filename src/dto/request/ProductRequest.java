package dto.request;

import entity.ProductFeatures;
import entity.ProductType;

public class ProductRequest {
    private int id;
    private String productName;
    private int productTypeId;
    private int productFee;
    private int productFeaturesId;


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

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getProductFee() {
        return productFee;
    }

    public void setProductFee(int productFee) {
        this.productFee = productFee;
    }

    public int getProductFeaturesId() {
        return productFeaturesId;
    }

    public void setProductFeaturesId(int productFeaturesId) {
        this.productFeaturesId = productFeaturesId;
    }
}


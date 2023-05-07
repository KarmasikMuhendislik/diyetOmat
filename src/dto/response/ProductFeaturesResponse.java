package dto.response;

import entity.ProductFeatures;

public class ProductFeaturesResponse {
    private String productEnergy;
    private String productCarbohydrate;
    private String productProtein;
    private String productOil;
    public ProductFeaturesResponse(String productOil, String productCarbohydrate, String productEnergy, String productProtein) {
    this.productCarbohydrate = productCarbohydrate;
    this.productOil = productOil;
    this.productProtein = productProtein;
    this.productEnergy = productEnergy;
    }
    public ProductFeaturesResponse(){

    }
    public String getProductEnergy() {
        return productEnergy;
    }

    public void setProductEnergy(String productEnergy) {
        this.productEnergy = productEnergy;
    }

    public String getProductCarbohydrate() {
        return productCarbohydrate;
    }

    public void setProductCarbohydrate(String productCarbohydrate) {
        this.productCarbohydrate = productCarbohydrate;
    }

    public String getProductProtein() {
        return productProtein;
    }

    public void setProductProtein(String productProtein) {
        this.productProtein = productProtein;
    }

    public String getProductOil() {
        return productOil;
    }

    public void setProductOil(String productOil) {
        this.productOil = productOil;
    }
}

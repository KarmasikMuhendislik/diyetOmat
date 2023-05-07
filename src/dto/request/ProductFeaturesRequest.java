package dto.request;

public class ProductFeaturesRequest {
    private String productEnergy;
    private String productCarbohydrate;
    private String productProtein;
    private String productOil;

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

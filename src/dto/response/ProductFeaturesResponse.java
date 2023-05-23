package dto.response;

public class ProductFeaturesResponse {
    private Integer productEnergy;
    private Integer productCarbohydrate;
    private Integer productProtein;
    private Integer productOil;
    public ProductFeaturesResponse(Integer productOil, Integer productCarbohydrate, Integer productEnergy, Integer productProtein) {
    this.setProductCarbohydrate(productCarbohydrate);
    this.setProductOil(productOil);
    this.setProductProtein(productProtein);
    this.setProductEnergy(productEnergy);
    }
    public ProductFeaturesResponse(){

    }

    public Integer getProductEnergy() {
        return productEnergy;
    }

    public void setProductEnergy(Integer productEnergy) {
        this.productEnergy = productEnergy;
    }

    public Integer getProductCarbohydrate() {
        return productCarbohydrate;
    }

    public void setProductCarbohydrate(Integer productCarbohydrate) {
        this.productCarbohydrate = productCarbohydrate;
    }

    public Integer getProductProtein() {
        return productProtein;
    }

    public void setProductProtein(Integer productProtein) {
        this.productProtein = productProtein;
    }

    public Integer getProductOil() {
        return productOil;
    }

    public void setProductOil(Integer productOil) {
        this.productOil = productOil;
    }
}

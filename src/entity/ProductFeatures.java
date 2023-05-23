package entity;

public class ProductFeatures {
    private int id;
    private Integer productEnergy;
    private Integer productCarbohydrate;
    private Integer productProtein;
    private Integer productOil;

    public ProductFeatures(Integer productEnergy, Integer productOil, Integer productCarbohydrate, Integer productProtein) {
        this.setProductEnergy(productEnergy);
        this.setProductOil(productOil);
        this.setProductCarbohydrate(productCarbohydrate);
        this.setProductProtein(productProtein);
    }
    public ProductFeatures(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

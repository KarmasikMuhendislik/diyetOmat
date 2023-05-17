package entity;

public class ProductType {
    private  int id;
    private  String typeName;
    private  String productTypeName;

    private String productPrimaryName;

    public ProductType(String typeName, String productTypeName,String productPrimaryName) {
        this.typeName = typeName;
        this.productTypeName = productTypeName;
        this.setProductPrimaryName(productPrimaryName);
    }
    public ProductType() {

    }
    public ProductType(int i, String typeName, String productTypeName) {
        this.id = i;
        this.typeName = typeName;
        this.productTypeName = productTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductPrimaryName() {
        return productPrimaryName;
    }

    public void setProductPrimaryName(String productPrimaryName) {
        this.productPrimaryName = productPrimaryName;
    }
}

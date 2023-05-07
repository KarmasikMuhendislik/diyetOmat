package entity;

public class ProductType {
    private  int id;
    private  String typeName;
    private  String productTypeName;

    public ProductType(String typeName, String productTypeName) {
        this.typeName = typeName;
        this.productTypeName = productTypeName;
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
}

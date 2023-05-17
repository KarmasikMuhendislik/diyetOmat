package dto.request;

public class ProductTypeRequest {
    private  String typeName;
    private  String productTypeName;
    private  String productPrimaryName;

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

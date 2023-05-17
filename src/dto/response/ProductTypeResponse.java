package dto.response;

public class ProductTypeResponse {
    private  String typeName;
    private  String productTypeName;
    private  String productPrimaryName;


    public ProductTypeResponse(String typeName, String productTypeName, String productPrimaryName) {
        this.typeName = typeName;
        this.productTypeName =productTypeName;
        this.productPrimaryName = productPrimaryName;
    }
    public ProductTypeResponse() {

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

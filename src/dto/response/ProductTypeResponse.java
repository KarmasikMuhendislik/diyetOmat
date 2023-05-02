package dto.response;

public class ProductTypeResponse {
    private  String typeName;
    private  String productTypeName;

    public ProductTypeResponse(String typeName, String productTypeName) {
        this.typeName = typeName;
        this.productTypeName =productTypeName;

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

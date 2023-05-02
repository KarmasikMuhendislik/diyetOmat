import controller.AdminController;
import dto.request.ProductTypeRequest;

import java.sql.SQLException;

public class Main  {
    public static void main(String[] args) throws SQLException {
        ProductTypeRequest productTypeRequest = new ProductTypeRequest();
        productTypeRequest.setTypeName("AÇlık ");
        productTypeRequest.setProductTypeName("aaaaa");
        AdminController adminController = new AdminController();
        adminController.productTypeAdd(productTypeRequest);
    }
}
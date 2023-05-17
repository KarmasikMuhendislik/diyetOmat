import controller.OtherControllers.ProductTypeController;
import java.sql.SQLException;
public class Main  {
    public static void main(String[] args) throws SQLException {
       ProductTypeController productTypeController =  new ProductTypeController();
       //productTypeController.addProductType(productTypeRequest);
       //productTypeController.deleteProductType(8);
        productTypeController.getProductPrimaryName();
    }
}
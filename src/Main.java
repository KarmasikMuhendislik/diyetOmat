import controller.DirectDiyetController;
import controller.OtherControllers.ProductTypeController;
import controller.OtoDiyetController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main  {
    public static void main(String[] args) throws SQLException {
       ProductTypeController productTypeController =  new ProductTypeController();
       productTypeController.getProductPrimaryName();
        DirectDiyetController directDiyetController = new DirectDiyetController();
        OtoDiyetController otoDiyetController = new OtoDiyetController();
        List<Integer> number= new ArrayList<>();
       // number.add(10);
       // number.add(11);
        //number.add(13);
        //otoDiyetController.optionCaloriAndProduct(245,number);
        directDiyetController.getProductList();
    }
}
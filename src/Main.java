import controller.OtherControllers.ProductController;
import controller.OtherControllers.ProductFeaturesController;
import controller.OtherControllers.ProductTypeController;
import controller.UserController;
import dto.request.ProductFeaturesRequest;
import dto.request.ProductRequest;
import dto.request.UserRequest;
import dto.response.ProductResponse;
import entity.Product;
import entity.ProductFeatures;
import entity.ProductType;
import entity.User;


import java.sql.SQLException;

public class Main  {
    public static void main(String[] args) throws SQLException {

        ProductController productController = new ProductController();
        ProductTypeController productTypeController = new ProductTypeController();
        ProductFeaturesController productFeaturesController = new ProductFeaturesController();
        ProductType productType = new ProductType(1,"Tokluk", "aaaaa");
        ProductFeatures productFeatures =  new ProductFeatures("33","21","12","44");
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductName("Elma");
        productRequest.setProductFee(32);
        productRequest.setProductTypeId(1);
        productRequest.setProductFeaturesId(2);

        /*  ProductFeaturesRequest  productFeaturesRequest =  new ProductFeaturesRequest();
        productFeaturesRequest.setProductOil("25");
        productFeaturesRequest.setProductCarbohydrate("52");
        productFeaturesRequest.setProductEnergy("32");
        productFeaturesRequest.setProductProtein("46");
        productFeaturesController.addProductFeatures(productFeaturesRequest);*/
        //productFeaturesController.deleteProductFeatures(4);
        //productController.addProduct(productRequest);
       // productController.getAllProduct();
        //productController.getProduct(4);
        /* productRequest.setProductName("Çilek");
        productRequest.setProductType(productTypeRequest);
        productRequest.setProductFeatures(productFeatures);
        productRequest.setProductFee(21);
        productController.addProduct(productRequest);*/

        UserRequest user = new UserRequest();
        user.setAge(23);
        user.setWeight(85);
        user.setHeight(187);
        user.setGender("E");
        UserController userController = new UserController();
        userController.addUser(user);
    }
}
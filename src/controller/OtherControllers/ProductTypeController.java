package controller.OtherControllers;

import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;
import service.ProductTypeService;
import service.serviceImpl.ProductTypeServiceImpl;

import java.sql.SQLException;

public class ProductTypeController {
    private final ProductTypeService productTypeService;

    public ProductTypeController( ) {
        this.productTypeService = new ProductTypeServiceImpl();
    }
    public ProductTypeResponse addProductType(ProductTypeRequest productTypeRequest) throws SQLException {
        return productTypeService.addProductType(productTypeRequest);
    }
    public Boolean deleteProductType(int id){
        return productTypeService.deleteProductType(id);
    }

    public ProductTypeResponse getProductType (int id){return productTypeService.getProductType(id);}

}

package controller.OtherControllers;

import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;
import entity.ProductType;
import service.ProductTypeService;
import service.serviceImpl.ProductTypeServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductTypeController {
    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }
    public ProductTypeResponse addProductType(ProductTypeRequest productTypeRequest)  {
        return productTypeService.addProductType(productTypeRequest);
    }
    public Boolean deleteProductType(int id){
        return productTypeService.deleteProductType(id);
    }

    public ProductTypeResponse getProductType (int id){return productTypeService.getProductType(id);}

    public List<String> getProductPrimaryName(){
        return productTypeService.getProductPrimaryName();
    }

    public List<Integer> getPrimaryName(String name){
        return productTypeService.getByPrimaryName(name);
    }

}

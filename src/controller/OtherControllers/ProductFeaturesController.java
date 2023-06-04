package controller.OtherControllers;

import dto.request.ProductFeaturesRequest;
import dto.response.ProductFeaturesResponse;
import entity.ProductFeatures;
import service.ProductFeaturesService;
import service.serviceImpl.ProductFeaturesServiceImpl;

public class ProductFeaturesController {

    private final ProductFeaturesService productFeaturesService;

    public ProductFeaturesController(ProductFeaturesService productFeaturesService ) {
        this.productFeaturesService = productFeaturesService;
    }
    public ProductFeaturesResponse addProductFeatures (ProductFeaturesRequest productFeaturesRequest){
        return productFeaturesService.addProdcutFeatures(productFeaturesRequest);
    }
    public Boolean deleteProductFeatures(int id){
        return productFeaturesService.deleteProdcutFeatures(id);
    }

    public ProductFeaturesResponse getProductFeatures(int id){
        return productFeaturesService.getProductFeatures(id);
    }


}

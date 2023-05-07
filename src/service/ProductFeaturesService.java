package service;

import dto.request.ProductFeaturesRequest;
import dto.response.ProductFeaturesResponse;

public interface ProductFeaturesService {
    ProductFeaturesResponse addProdcutFeatures(ProductFeaturesRequest productFeaturesRequest);

    Boolean deleteProdcutFeatures(int id);

    ProductFeaturesResponse getProductFeatures(int id);
}
